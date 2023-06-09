package com.suitt.controllers.rest;

import com.suitt.tables.cinemaShow.CinemaShowDto;
import com.suitt.tables.cinemaShow.CinemaShowService;
import com.suitt.tables.film.FilmDto;
import com.suitt.tables.film.FilmService;
import com.suitt.tables.genre.GenreDto;
import com.suitt.tables.genre.GenreService;
import com.suitt.tables.hall.HallDto;
import com.suitt.tables.hall.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GetRestController {
    private final FilmService filmService;
    private final HallService hallService;
    private final CinemaShowService cinemaShowService;
    private final GenreService genreService;

    @GetMapping("/schedule/films/{id}")
    public Map<String, Object> getFilmSchedule(@PathVariable Long id){
        Map<String, Object> result = new HashMap<>();
        var film = filmService.getFilm(id);
        result.put("film", film);
        result.put("cinemaShows", cinemaShowService.getNearestByFilmId(id, 1000));
        result.put("halls", hallService.getHallsFromCinemaShows(film.cinemaShows()));
        return result;
    }

    @GetMapping("/films/{id}")
    public FilmDto getFilm(@PathVariable Long id){
        return filmService.getFilm(id);
    }

    @GetMapping("/shows/{id}")
    public CinemaShowDto getCinemaShow(@PathVariable Long id){
        return cinemaShowService.getCinemaShow(id);
    }

    @GetMapping("/genres")
    public List<GenreDto> films(){
        return genreService.getAll();
    }

    @GetMapping("/halls")
    public List<HallDto> cinemaShows(){
        return hallService.getAll();
    }
}
