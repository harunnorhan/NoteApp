package com.example.noteapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.data.local.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    // Get all notes from database
    @Query("SELECT * FROM notes ORDER BY createdDate")
    fun getAllNotes(): Flow<List<Note>>

    // Get a specific note from database with id (primary key)
    @Query("SELECT * FROM notes WHERE id=:id ORDER BY createdDate")
    fun getNoteById(id: Long): Flow<Note>

    // Insert note
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    // Update note
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    // Delete note
    @Query("DELETE FROM notes WHERE id=:id")
    suspend fun delete(id: Long)

    //Get all bookmarked notes from database
    @Query("SELECT * FROM notes WHERE isBookMarked = 1 ORDER BY createdDate DESC")
    fun getBookmarkedNotes(): Flow<List<Note>>
}