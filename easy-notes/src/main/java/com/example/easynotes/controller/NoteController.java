package com.example.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {
	
	@Autowired
	NoteService noteService;
	
	@GetMapping
	public List<Note> getAllNotes(
			@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "5") int pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {
		return noteService.findAllNotes(pageNo, pageSize, sortBy);
	}
	
	@PostMapping
	public Note createNote(@Valid @RequestBody Note note) {
		return noteService.createNote(note);
	}
	
	@GetMapping("/{id}")
	public Note findNoteById(@PathVariable(value = "id") Long noteId) {
		try {
			return noteService.findNoteById(noteId);
		} catch (ResourceNotFoundException resourceNotFoundException) {
			throw resourceNotFoundException;
		} catch (Exception exception) {
			throw exception;
		}
		
	}
	
	@PutMapping("/{id}")
	public Note updateNoteById(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails) {
		try {
			return noteService.updateNoteById(noteId, noteDetails);
		} catch (ResourceNotFoundException resourceNotFoundException) {
			throw resourceNotFoundException;
		} catch (Exception exception) {
			throw exception;
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteNoteById(@PathVariable(value = "id") Long noteId) {
		try {
			noteService.deleteNoteById(noteId);
			return ResponseEntity.ok().build();
		} catch (ResourceNotFoundException resourceNotFoundException) {
			throw resourceNotFoundException;
		} catch (Exception exception) {
			throw exception;
		}
	}

}
