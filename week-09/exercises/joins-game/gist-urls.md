# Individual Student Gists

Create individual private gists for each student using the files in this repository. Each gist should contain 2 files: `question.md` and `[tablename].sql`

## Hub Tables (Priority - Must be created)

### Student 1 - students (HUB)
- **Files**: `hubs/student-01-students/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: enrollments, transcripts, advisors

### Student 5 - courses (HUB)
- **Files**: `hubs/student-05-courses/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: prerequisites, sections, textbooks

### Student 9 - professors (HUB)
- **Files**: `hubs/student-09-professors/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: professor_courses, office_assignments, research_grants

### Student 13 - buildings (HUB)
- **Files**: `hubs/student-13-buildings/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: classrooms, maintenance_requests, security_logs

### Student 17 - meal_plans (HUB)
- **Files**: `hubs/student-17-meal-plans/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: student_meal_accounts, dining_transactions, plan_changes

## Main Satellite Tables (Critical Connections)

### Student 2 - enrollments
- **Files**: `satellites/main/student-02-enrollments/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: students (hub)

### Student 6 - prerequisites
- **Files**: `satellites/main/student-06-prerequisites/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: courses (hub)

### Student 10 - professor_courses
- **Files**: `satellites/main/student-10-professor-courses/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: professors (hub)

### Student 14 - classrooms
- **Files**: `satellites/main/student-14-classrooms/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: buildings (hub)

### Student 18 - student_meal_accounts
- **Files**: `satellites/main/student-18-student-meal-accounts/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: meal_plans (hub)

## Additional Satellite Tables

### Student 3 - transcripts
- **Files**: `satellites/additional/student-03-transcripts/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: students (hub)

### Student 4 - advisors
- **Files**: `satellites/additional/student-04-advisors/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: students (hub)

### Student 7 - sections
- **Files**: `satellites/additional/student-07-sections/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: courses (hub)

### Student 8 - textbooks
- **Files**: `satellites/additional/student-08-textbooks/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: courses (hub)

### Student 11 - office_assignments
- **Files**: `satellites/additional/student-11-office-assignments/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: professors (hub)

### Student 12 - research_grants
- **Files**: `satellites/additional/student-12-research-grants/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: professors (hub)

### Student 15 - maintenance_requests
- **Files**: `satellites/additional/student-15-maintenance-requests/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: buildings (hub)

### Student 16 - security_logs
- **Files**: `satellites/additional/student-16-security-logs/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: buildings (hub)

### Student 19 - dining_transactions
- **Files**: `satellites/additional/student-19-dining-transactions/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: meal_plans (hub)

### Student 20 - plan_changes
- **Files**: `satellites/additional/student-20-plan-changes/`
- **Gist URL**: _[Create gist from files above]_
- **Connects to**: meal_plans (hub)

## Instructions for Creating Gists

1. Go to https://gist.github.com
2. For each student, create a **Secret Gist** (not public)
3. Add 2 files from their respective directory:
   - Copy content from `question.md`
   - Copy content from `[tablename].sql`
4. Save as secret gist and copy URL
5. Update the URLs in this file
6. Distribute individual URLs to students

## Game Strategy

For a minimum viable game:
- **Must have**: All 5 hubs + their main satellite connections (10 students)
- **Enhanced experience**: Add additional satellites as needed (up to 20 students)
- **Discovery element**: Students don't know who has what table until they talk