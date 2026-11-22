# BlazeBoost

Лёгкий клиентский Fabric-мод для Minecraft 1.21.11 (Java 21).

- Автоматически ставит быстрые настройки: дальность 8, симуляция 6, графика Fast, облака выкл, AO выкл, VSync выкл, FPS без лимита
- Не рисует далёкие сущности (>64 бл.) и предметы/опыт (>24 бл.)
- Не создаёт частицы дальше 32 блоков
- Клавиша **K** — вкл/выкл

Сборка: `gradle build` → `build/libs/blazeboost-1.0.0.jar`. На GitHub jar собирается автоматически (Actions → build → Artifacts).
Для максимального буста ставь вместе с Sodium, Lithium, FerriteCore, EntityCulling.
