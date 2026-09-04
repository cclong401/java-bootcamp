1. Map - Key -> value pairs, unique keys
2. Set - Unique values
3. List - Indexed items, duplicates allowed
4. TreeSet/TreeMap - Sorted
5. LinkedHashSet/LinkedHashMap - Insertion order preserved

# Reference
| # | Scenario | Interface | Implementation | Why |
| - | -------- | --------- | -------------- | --- |
| 1 | Ordered catalog; duplicate titles allowed | `List<Book>` | `ArrayList<>` | Indexed sequence; duplicates OK |
| 2 | Unique registered book IDs | `Set<String>` | `HashSet<>` | No duplicates; fast membership |
| 3 | Book ID → current borrower ID | `Map<String, String>` | `HashMap<>` | Direct key → value lookup |
| 4 | Alphabetically sorted categories | `Set<String>` | `TreeSet<>` | Unique values; natural sort order |
| 5 | Category → count, sorted by category | `Map<String, Integer>` | `TreeMap<>` | Key → value with sorted keys |
| 6 | Checkout history in event order | `List<BorrowRecord>` | `ArrayList<>` | Append + iterate in insertion order |