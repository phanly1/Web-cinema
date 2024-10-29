package com.team12.fantafilm.repository;
import com.team12.fantafilm.model.Movie;
import jakarta.persistence.OrderBy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("FROM Movie m order by m.premiereDate desc ")
    List<Movie> showAll();

    @Query("FROM Movie m where m.status like 'On air'")
    List<Movie> showPhimDangChieu();

    @Query(" from Movie m where m.status like 'Incoming' ")
    List<Movie> showPhimSapChieu();

    @Query(" from Movie m where m.status in ('On air', 'Incoming')")
    List<Movie> showPhimSapChieuAndDangChieu();

    String movie = ("SELECT DISTINCT  m.*\n" +
            "            from datn.cinema c\n" +
            "            join datn.room r on r.cinema_id = c.id\n" +
            "            join datn.schedule s on s.room_id = r.id\n" +
            "           join datn.movie m on m.id = s.movie_id\n" +
            "            where m.id=:movieId\n" +
            "            and c.id =:cinemaId");

    @Query(value = movie, nativeQuery = true)
    List<Movie> getMovie(@Param("movieId") String movieId, @Param("cinemaId") String cinemaId);

    Page<Movie> findByNameContains(String keyword, Pageable pageable);

    Movie findByNameLike(String name);
    //
    @Query(" SELECT DISTINCT m" +
            " FROM Movie m " +

            " LEFT JOIN m.directors d " +
            "LEFT JOIN m.languages lang " +
            "LEFT JOIN m.movieTypes type " +
            "LEFT JOIN m.performers performer " +
            "WHERE " +
            "    COALESCE(:directors, :languages, :movieTypes, :performers, :status, :keyword) IS NOT NULL" +
            "    AND (:directors IS NULL OR d.name IN :directors)    " +
            "    AND (:languages IS NULL OR lang.name IN :languages) " +
            "    AND (:movieTypes IS NULL OR type.name IN :movieTypes) " +
            "    AND (:performers IS NULL OR performer.name IN :performers)" +
            "    AND (:status IS NULL OR m.status IS NULL OR m.status LIKE %:status%)" +
            "    AND (:keyword IS NULL OR m.name LIKE %:keyword% " +
            "        OR d.name LIKE %:keyword% " +
            "        OR lang.name LIKE %:keyword% " +
            "        OR type.name LIKE %:keyword% " +
            "        OR performer.name LIKE %:keyword% )"
            +"ORDER BY m.premiereDate desc"
            )
    Page<Movie> filterMovies(Pageable pageable,
                             @Param("directors") String directors,
                             @Param("languages") String languages,
                             @Param("movieTypes") String movieTypes,
                             @Param("performers") String performers,
                             @Param("status") String status,
                             @Param("keyword") String keyword
    );


    @Query(" SELECT DISTINCT m" +
            " FROM Movie m " +
            "LEFT JOIN m.directors d " +
            "LEFT JOIN m.languages lang " +
            "LEFT JOIN m.movieTypes type " +
            "LEFT JOIN m.performers performer " +
            "WHERE " +
            "    COALESCE(:directors, :languages, :movieTypes, :performers, :status, :keyword) IS NOT NULL" +
            "    AND (:directors IS NULL OR d.name IN :directors)    " +
            "    AND (:languages IS NULL OR lang.name IN :languages) " +
            "    AND (:movieTypes IS NULL OR type.name IN :movieTypes) " +
            "    AND (:performers IS NULL OR performer.name IN :performers)" +
            "    AND (:status IS NULL OR m.status IS NULL OR m.status LIKE %:status%)" +
            "    AND (:keyword IS NULL OR m.name LIKE %:keyword% " +
            "        OR d.name LIKE %:keyword% " +
            "        OR lang.name LIKE %:keyword% " +
            "        OR type.name LIKE %:keyword% " +
            "        OR performer.name LIKE %:keyword% )" +
            "AND m.status like 'On Air'")
    List<Movie> filterMoviesTrangChu(
            @Param("directors") String directors,
            @Param("languages") String languages,
            @Param("movieTypes") String movieTypes,
            @Param("performers") String performers,
            @Param("status") String status,
            @Param("keyword") String keyword
    );
}
