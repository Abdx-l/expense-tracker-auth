package dev.akhras;
import org.springframework.data.jpa.repository.*;import org.springframework.data.repository.query.Param;import jakarta.persistence.LockModeType;import java.util.*;import java.time.*;import java.math.*;
interface Users extends JpaRepository<Domain.User,String>{Optional<Domain.User>findByEmail(String email);}
interface Refreshes extends JpaRepository<Domain.Refresh,String>{@Lock(LockModeType.PESSIMISTIC_WRITE) @Query("select r from RefreshToken r where r.hash=:hash")Optional<Domain.Refresh>locked(@Param("hash")String hash);}
interface Accounts extends JpaRepository<Domain.Account,Long>{List<Domain.Account>findByOwner(String owner);Optional<Domain.Account>findByIdAndOwner(Long id,String owner);}
interface Expenses extends JpaRepository<Domain.Expense,Long>{List<Domain.Expense>findByOwnerAndOccurredBetween(String owner,LocalDate start,LocalDate end);}
interface Budgets extends JpaRepository<Domain.Budget,Long>{List<Domain.Budget>findByOwnerAndMonth(String owner,String month);}
