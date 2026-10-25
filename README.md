# Expense Tracker with Auth

Spring Boot/React expense tracker with BCrypt registration/login, signed 15-minute JWT access tokens, hashed rotating refresh tokens, per-user accounts/expenses/budgets, monthly category summaries, an Axios refresh interceptor, Recharts views and auth/money tests. Default H2 enables a local run; PostgreSQL is configurable.

## Run

Java 17/Maven: `mvn test && mvn spring-boot:run`. Set JWT_SECRET to a unique 32+ character key. UI: `cd web && npm install && npm run dev`. Register, create an account, add expenses and set category budgets.
