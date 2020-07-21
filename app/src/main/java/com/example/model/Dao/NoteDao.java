package com.example.model.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.model.Entity.Note;

import java.util.List;

@Dao
public interface NoteDao {
    //insert note
    @Insert
    void insert(Note note);

    ///update note
    @Update
    void update(Note note);

    //delete note
    @Delete
    void delete(Note note);

    //Delete all Notes
    @Query("DELETE FROM NOTE_TABLE")
    void deleteAllNotes();

    //get All Note
    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();
}
