package com.example.easynotes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;

@Service
public class NoteService {
	
	@Autowired
	NoteRepository noteRepository;
	
	public List<Note> findAllNotes(int pageNo, int pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
		Page<Note> pagedResult = noteRepository.findAll(paging);
		return pagedResult.hasContent() ? pagedResult.getContent() : new ArrayList<Note>();
	}
	
	public Note createNote(Note note) {
		return noteRepository.save(note);
	}
	
	public Note findNoteById(Long noteId) {
		try {
			return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
		} catch (ResourceNotFoundException resourceNotFoundException) {
			throw resourceNotFoundException;
		}
		
	}
	
	public Note updateNoteById(Long noteId, Note noteDetails) {
		try {
			Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
			note.setTitle(noteDetails.getTitle());
			note.setContent(noteDetails.getContent());
			return noteRepository.save(note);
		} catch (ResourceNotFoundException resourceNotFoundException) {
			throw resourceNotFoundException;
		}
	}
	
	public void deleteNoteById(Long noteId) {
		try {
			Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
			noteRepository.delete(note);
		} catch (ResourceNotFoundException resourceNotFoundException) {
			throw resourceNotFoundException;
		}
		
	}

}
