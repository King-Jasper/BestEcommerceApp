package jaspertechShoppingCentre.repositories;

import jaspertechShoppingCentre.entity.JwtToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JwtTokenRepository extends JpaRepository<JwtToken, Long> {
    @Query("""
    SELECT t FROM JwtToken t INNER JOIN t.appUser u WHERE u.id = :appUserId AND (t.isExpired = false OR t.isRevoked = false)
""")
    List<JwtToken> findAllByAppUserAndNotExpiredOrRevoked(Long appUserId);

    Optional<JwtToken> findByAccessToken(String accessToken);

}
