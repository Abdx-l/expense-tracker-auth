package dev.akhras;
import jakarta.persistence.*;import java.time.*;import java.math.*;
public class Domain{
 @Entity @Table(name="app_users")public static class User{@Id public String id;@Column(unique=true,nullable=false)public String email;public String password;}
 @Entity public static class Refresh{@Id public String hash;public String owner;public Instant expires;}
 @Entity public static class Account{@Id @GeneratedValue public Long id;public String owner;public String name;}
 @Entity public static class Expense{@Id @GeneratedValue public Long id;public String owner;public Long accountId;public String category;public LocalDate occurred;public BigDecimal amount;}
 @Entity public static class Budget{@Id @GeneratedValue public Long id;public String owner;@Column(name="budget_month") public String month;public String category;public BigDecimal amount;}
 public static BigDecimal amount(BigDecimal value){if(value==null||value.signum()<=0||value.scale()>2)throw new IllegalArgumentException("positive amount with at most two decimals required");return value;}
}
