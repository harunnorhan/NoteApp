package com.example.noteapp.domain.use_cases

import com.example.noteapp.data.local.model.Note
import com.example.noteapp.domain.repository.Repository
import javax.inject.Inject

class AddUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(note: Note) = repository.insert(note)
}