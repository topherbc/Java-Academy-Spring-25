# MySQL JOINs Game

## Setup
- **20 students, each with their own unique table**
- **5 hub tables** scattered among students (they don't know who has hubs)
- **15 satellite tables** that connect to various hubs
- Students must discover their connections through conversation

## The Hunt
**Hub table holders**: "Who has data that connects to mine?"
**Satellite table holders**: "Which hub table am I supposed to connect to?"

## Round 1: Find Your Connection (10 min)
Walk around and figure out:
- **If you have a hub table**: "Which of my records connect to someone else's table?"
- **If you don't have the hub**: "What info from the hub table relates to my data?"

Write down who you connect to and which columns link you together.

## Round 2: Write Your JOIN (15 min)
Everyone writes **one SQL JOIN query** connecting their table to exactly one other table.

**Submit your individual query** - I'll run them and show the results.

## Round 3: Collaborate (15 min)
Work with others who connect to the same hub to write **multi-table queries** that show the relationships.

## Grand Finale
I'll show you the mega-query that connects all 20 tables across every hub. Mind = blown

---

## Hub Tables (Hidden Among Students)
- **students** - Student records
- **courses** - Course catalog
- **professors** - Faculty information  
- **buildings** - Campus facilities
- **meal_plans** - Dining services

## File Organization
- `hubs/` - Contains the 5 hub table student files
- `satellites/main/` - Critical satellite tables that connect directly to hubs
- `satellites/additional/` - Additional satellite tables for more complex relationships
- `gist-urls.md` - Links to individual student gists (to be created)

## Creating Individual Gists
1. Each student gets their own private gist with 2 files:
   - `question.md` - Their specific question and instructions
   - `[tablename].sql` - Their table structure and data
2. Students only see their own gist, maintaining the discovery aspect
3. Game creates realistic database exploration scenarios

**Remember**: Everyone writes exactly one individual JOIN, then collaborate on multi-table queries!