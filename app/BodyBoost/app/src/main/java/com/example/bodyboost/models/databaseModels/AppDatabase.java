package com.example.bodyboost.models.databaseModels;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.bodyboost.models.DayWorkout;
import com.example.bodyboost.models.Days;
import com.example.bodyboost.models.Exercise;
import com.example.bodyboost.models.ExerciseSet;
import com.example.bodyboost.models.ExerciseSteps;
import com.example.bodyboost.models.Feed;
import com.example.bodyboost.models.Ingredients;
import com.example.bodyboost.models.MealIngredients;
import com.example.bodyboost.models.Meals;
import com.example.bodyboost.models.Report;
import com.example.bodyboost.models.User;
import com.example.bodyboost.models.UserCompleted;
import com.example.bodyboost.models.UserPlan;
import com.example.bodyboost.models.WorkoutPlan;
import com.example.bodyboost.R;

@Database(entities = {Report.class, Days.class, Exercise.class, ExerciseSteps.class , ExerciseSet.class, WorkoutPlan.class, DayWorkout.class , Feed.class, Meals.class, Ingredients.class, MealIngredients.class, User.class, UserPlan.class, UserCompleted.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ReportDao getReportDao();
    public abstract DaysDao getDaysDao();
    public abstract ExerciseStepsDao getExerciseStepsDao();
    public abstract ExerciseSetDao getExerciseSetDao();
    public abstract WorkoutPlanDao getWorkoutPlanDao();
    public abstract DayWorkoutDao getDayWorkoutDao();
    public abstract FeedDao getFeedDao();
    public abstract MealsDao getMealsDao();
    public abstract IngredientsDao getIngredientsDao();
    public abstract MealIngredientsDao getMealIngredientsDao();
    public abstract UserPlanDao getUserPlanDao();
    public abstract UserDao getUserDao();
    public abstract UserCompletedDao getUserCompletedDao();

    // Gets an instance of the app database
    private static AppDatabase INSTANCE;


    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "AppDatabase").allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            // Days and exercises
                            db.execSQL("INSERT INTO Days (dayId, day) VALUES (0, 'Monday')");
                            db.execSQL("INSERT INTO Days (day) VALUES ('Tuesday')");
                            db.execSQL("INSERT INTO Days (day) VALUES ('Wednesday')");
                            db.execSQL("INSERT INTO Days (day) VALUES ('Thursday')");
                            db.execSQL("INSERT INTO Days (day) VALUES ('Friday')");
                            db.execSQL("INSERT INTO Days (day) VALUES ('Saturday')");
                            db.execSQL("INSERT INTO Days (day) VALUES ('Sunday')");

                            // Exercises AND ExerciseSteps
                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Push-up chair dips', 'A compound exercise that targets the chest, triceps, and shoulders. Begin with a push-up position and lower your body by bending your arms, then use your triceps to push yourself back up while keeping your legs elevated on a chair.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(1, " + R.drawable.chairdips_1 + ");");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(1, " + R.drawable.chairdips_2 + ");");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Wall push-ups', 'A modified version of push-ups where you perform the exercise against a wall instead of on the floor. It targets the chest, shoulders, and triceps.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(2, " + R.drawable.wallpushup_1 + ");");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(2, " + R.drawable.wallpushup_2 + ");");

                            db.execSQL("INSERT INTO Exercise ( exerciseName, exerciseDescription) VALUES ('Jump rope', 'A cardiovascular exercise that involves jumping over a rope as it passes under your feet. It improves coordination, endurance, and cardiovascular health.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(3, '" + R.drawable.jumprope_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(3, '" + R.drawable.jumprope_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Knee push-ups', 'An easier variation of push-ups where you perform the exercise with your knees on the ground. It targets the chest, shoulders, and triceps.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(4, '" + R.drawable.kneebentpushup_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(4, '" + R.drawable.kneebentpushup_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Squat', 'A lower body exercise that targets the quadriceps, hamstrings, and glutes. Start with your feet shoulder-width apart, lower your body by bending your knees, and then return to the starting position.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(5, '" + R.drawable.squat_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(5, '" + R.drawable.squat_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Front jumps', 'A plyometric exercise that involves jumping laterally from side to side. It improves lower body strength, agility, and cardiovascular fitness.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(6, '" + R.drawable.jumps_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(6, '" + R.drawable.jumps_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Deep crunch', 'An abdominal exercise that targets the rectus abdominis. Lie on your back, bend your knees, and curl your upper body off the floor to engage your abs.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(7, '" + R.drawable.crunch_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(7, '" + R.drawable.crunch_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Side leg raises', 'A lower body exercise that targets the hip abductors. Lie on your side and lift your top leg upward while keeping it straight.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(8, '" + R.drawable.legraises_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(8, '" + R.drawable.legraises_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Donkey kicks', 'A bodyweight exercise that targets the glutes. Get on all fours and kick your leg back while keeping your knee bent.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(9, '" + R.drawable.donkey_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(9, '" + R.drawable.donkey_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('One-arm push-ups', 'A challenging variation of push-ups that targets the chest, triceps, and shoulders. Perform a push-up while balancing on one hand and keeping your body straight.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(10, '" + R.drawable.onearm_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(10, '" + R.drawable.onearm_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Wide-arm push-ups', 'A variation of push-ups that targets the chest, shoulders, and triceps. Place your hands wider than shoulder-width apart while maintaining proper form.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(11, '" + R.drawable.wide_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(11, '" + R.drawable.wide_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Diamond push-ups', 'A triceps-focused variation of push-ups. Place your hands close together in a diamond shape beneath your chest while performing the exercise.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(12, '" + R.drawable.diamond_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(12, '" + R.drawable.diamond_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Abdominal crunch', 'A classic abdominal exercise that targets the rectus abdominis. Lie on your back, bend your knees, and lift your shoulders off the floor while keeping your lower back pressed into the ground.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(13, '" + R.drawable.bicycle_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(13, '" + R.drawable.bicycle_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Mountain climbers', 'A full-body exercise that targets the core, shoulders, and legs. Begin in a plank position and alternate bringing your knees toward your chest in a running motion.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(14, '" + R.drawable.mountain_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(14, '" + R.drawable.mountain_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Heel touch', 'An oblique exercise that targets the side abdominals. Lie on your back with your knees bent, and touch your heels with your fingertips while engaging your obliques.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(15, '" + R.drawable.heel_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(15, '" + R.drawable.heel_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Russian twist', 'An oblique-strengthening exercise that targets the side abdominals. Sit on the floor, lean back slightly, and twist your torso from side to side while holding a weight or touching the floor with your hands.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(16, '" + R.drawable.twist_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(16, '" + R.drawable.twist_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Leg raises', 'An abdominal exercise that targets the lower abs. Lie on your back, raise your legs off the ground while keeping them straight, and lower them back down without touching the floor.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(17, '" + R.drawable.raise_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(17, '" + R.drawable.raise_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Jumping jacks', 'A full-body cardiovascular exercise. Start with your feet together and arms by your sides, then jump while spreading your legs apart and raising your arms above your head. Jump again to return to the starting position.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(18, '" + R.drawable.jacks_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(18, '" + R.drawable.jacks_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Burpees', 'A full-body exercise that combines a squat, plank, and jump. Begin in a standing position, drop into a squat, kick your feet back into a plank, jump your feet back to the squat position, and finally jump explosively into the air with your arms raised.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(19, '" + R.drawable.burpee_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(19, '" + R.drawable.burpee_2 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(19, '" + R.drawable.burpee_3 + "');");


                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Skipping', 'A cardiovascular exercise that involves jumping over a rope while holding the ends. It improves coordination, endurance, and cardiovascular health.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(20, '" + R.drawable.skipping_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(20, '" + R.drawable.skipping_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Plank', 'A core-strengthening exercise that targets the abs, back, and shoulders. Start in a push-up position and hold your body in a straight line, supporting yourself with your forearms and toes.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(22, '" + R.drawable.plank + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('V-sit crunch', 'An advanced abdominal exercise that targets the entire core. Sit on the floor, lean back slightly, lift your legs off the ground, and bring your chest and knees toward each other to form a V shape.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(23, '" + R.drawable.vcrunch_1 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Extended-arm crunch', 'A variation of the traditional crunch exercise that targets the upper abs. Lie on your back, extend your arms overhead, and lift your upper body off the floor while reaching toward your toes.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image)  VALUES(24, '" + R.drawable.extendedcrunch_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image)  VALUES(24, '" + R.drawable.extendedcrunch_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Barbell bench press', 'A compound exercise that targets the chest, shoulders, and triceps. Lie on a bench, grip the barbell with an overhand grip, and lower it to your chest before pressing it back up.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(25, '" + R.drawable.benchpress_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(25, '" + R.drawable.benchpress_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Pull-ups', 'An upper body exercise that targets the back and arms. Hang from a bar with an overhand grip and pull your body upward until your chin reaches the bar.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(26, '" + R.drawable.pullup_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(26, '" + R.drawable.pullup_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Straight Supine with Bar', 'A compound exercise that targets the chest, shoulders, and triceps. Lie on your back, grip a barbell with an overhand grip, and press it upward from your chest.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(27, '" + R.drawable.stretch_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(27, '" + R.drawable.stretch_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Chest in parallel', 'A chest exercise that targets the pectoral muscles. Sit on a chest press machine with your hands on the handles, push the handles forward, and return them to the starting position.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(28, '" + R.drawable.parallelbar_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(28, '" + R.drawable.parallelbar_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Plank Shoulder Taps', 'Plank Shoulder Taps is a core-strengthening exercise where you tap your shoulders alternately in a high plank position. It targets your core, shoulders, arms, and back. No equipment needed.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(29, '" + R.drawable.sholdertaps_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(29, '" + R.drawable.sholdertaps_2 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(29, '" + R.drawable.sholdertaps_3 + "');");


                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Wall Plank', 'A wall plank is a fitness exercise where you assume a plank position with your feet against a wall instead of the ground. It targets the core muscles and helps build strength and stability.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(30, '" + R.drawable.wallplank_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(30, '" + R.drawable.wallplank_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Front raise with water bottles', 'A shoulder exercise that targets the front deltoids. Stand with dumbbells or water bottles in your hands, palms facing your body, and raise the weights in front of you until they reach shoulder level.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(31, '" + R.drawable.shoulderraise_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(31, '" + R.drawable.shoulderraise_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Close-grip push-ups', 'Close-grip push-ups: Hands close together, targets triceps while engaging chest and shoulders for overall upper body strength.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(32, '" + R.drawable.closegrip_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(32, '" + R.drawable.closegrip_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Australian Pull-Up', 'The Bodyweight Row, also called the Australian Pull-Up, is a no-equipment exercise where you lie under a sturdy surface, grip the edge, and pull your chest towards it. It strengthens the upper back, biceps, and core muscles.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(33, '" + R.drawable.australian_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(33, '" + R.drawable.australian_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Isometric squat', 'A lower body exercise that targets the quadriceps, hamstrings, and glutes. Hold a squat position with your thighs parallel to the ground for a set amount of time.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(34, '" + R.drawable.isometricsquat_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(34, '" + R.drawable.isometricsquat_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Bulgarian squat', 'A single-leg exercise that targets the quadriceps, hamstrings, and glutes. Place one foot on a raised surface behind you and lower your body into a lunge position.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(35, '" + R.drawable.bulgarian_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(35, '" + R.drawable.bulgarian_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Prone Superman', 'The Prone Superman is a no-equipment exercise where you lie facedown, lift your chest, arms, and legs off the ground, and hold for a moment. It strengthens your lower back, glutes, and posterior shoulder muscles while improving core stability and posture.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(36, '" + R.drawable.superman_1 + "');");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(36, '" + R.drawable.superman_2 + "');");

                            db.execSQL("INSERT INTO Exercise (exerciseName, exerciseDescription) VALUES ('Jumping jacks', 'A full-body cardiovascular exercise. Start with your feet together and arms by your sides, then jump while spreading your legs apart and raising your arms above your head. Jump again to return to the starting position.')");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(37, " + R.drawable.jacks_1 +");");
                            db.execSQL("INSERT INTO ExerciseSteps (exerciseId, image) VALUES(37, " + R.drawable.jacks_2 + ");");
                            // Exercise set

                            // Exercise set - Monday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 1, 1, 10, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 2, 2, 20, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 3, 3, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 5, 4, 0, '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 11, 5, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 12, 6, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 13, 7, 0, '30 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 28, 8, 15, null)");

                            // Exercise set - Tuesday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (1, 4, 1, 0, '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (1, 20, 2, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (1, 23, 3, 0, '45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (1, 26, 4, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (1, 28, 5, 12, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (1, 33, 6, 10, null)");

                            // Exercise set - Wednesday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (2, 1, 1, 10, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (2, 3, 2, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (2, 5, 3, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (2, 11, 4, 14, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (2, 12, 5, 14, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (2, 26, 6, 12, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (2, 27, 7, 12, null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (2, 28 , 8, 8  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (2, 30 , 9, 8  , null)");


                            // Exercise set - Thursday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (3, 6, 1, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (3, 7, 2, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (3, 8, 3, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (3, 9, 4, 12, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (3, 10, 5, 10, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (3, 13, 6, 14, null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (3, 31 , 7, 8  , null)");


                            // Exercise set - Friday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 4, 1, 0, '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 20, 2, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 23, 3, 0, '45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 34, 4, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 35, 5, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 36, 6, 12, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 37, 7, 10, null)");

                            // Exercise set - Saturday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 14, 1, 10, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 15, 2, 12, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 16, 3, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 17, 4, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 18, 5, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 24, 6, 12, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 25, 7, 10, null)");


                            // Exercise set - Sunday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (6, 19, 1, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (6, 20, 2, 0, '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (6, 22, 4, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (6, 23, 5, 0, '45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (6, 29, 6, 8, null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (6, 32 , 7, 8  , null)");


                            // WORKOUT PLANS

                            // WORKOUT PLAN - 1

                            // Workout Plan - 1 - day 1
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 1, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 2, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 3, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 5, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 11, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 12, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 13, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 28, 'gain mass')");

                            // Workout Plan - 1 - day 2
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 1, 4, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 1, 20, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 1, 23, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 1, 26, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 1, 28, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 1, 33, 'gain mass')");

                            // Workout Plan - 1 - day 3
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 1, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 3, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 5, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 11, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 12, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 26, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 27, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 28, 'gain mass')");

                            // Workout Plan - 1 - day 4
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 3, 6, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 3, 7, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 3, 8, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 3, 9, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 3, 10, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 3, 13, 'gain mass')");


                            // Workout Plan - 1 - day 5
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 4, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 20, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 23, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 34, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 35, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 36, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 37, 'gain mass')");

                            // Workout Plan - 1 - day 6
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 14, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 15, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 16, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 17, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 18, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 24, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 25, 'gain mass')");


                            // Workout Plan - 1 - day 7
                            db.execSQL("INSERT INTO WorkoutPlan('planId', 'dayId', 'exerciseId', 'type') Values (1, 6 , 19, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan('planId', 'dayId', 'exerciseId', 'type') Values (1, 6 , 20, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan('planId', 'dayId', 'exerciseId', 'type') Values (1, 6 , 22, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan('planId', 'dayId', 'exerciseId', 'type') Values (1, 6 , 23, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan('planId', 'dayId', 'exerciseId', 'type') Values (1, 6 , 29, 'gain mass')");


                            // WORKOUT PLAN - 2
                            // Workout Plan - 2 - day 1
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 36, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 23, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 4, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 11, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 16, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 7, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 6, 'lose weight')");


                            // Workout Plan - 2 - day 2
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 1, 5, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 1, 16, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 1, 18, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 1, 29, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 1, 28, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 1, 33, 'lose weight')");


                            // Workout Plan - 2 - day 3
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 10, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 30, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 15, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 24, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 25, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 27, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 28, 'lose weight')");

                            // Workout Plan - 2 - day 4
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 3, 33, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 3, 31, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 3, 6, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 3, 9, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 3, 13, 'lose weight')");

                            // Workout Plan - 2 - day 5
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 18, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 8, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 3, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 9, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 23, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 30, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 37, 'lose weight')");

                            // Workout Plan - 2 - day 6
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 5, 31, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 5, 17, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 5, 14, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 5, 18, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 5, 3, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 5, 8, 'lose weight')");

                            // Workout Plan - 2 - day 7
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 6, 26, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 6, 27, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 6, 17, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 6, 32, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 6, 5, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 6, 24, 'lose weight')");

                            //DayWorkout
                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(0,1, 'Whats a better way to start of the week with some knee-push-ups or some russian twists? This full body exercise set is awaiting you!')");
                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(1,1, 'From planks to squats, this exercise set will target your abdominals and lower body to its best!')");
                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(2,1, 'Do you feel like working out your arms and shoulders with some plank shoulder taps or front raise with water bottles? Well thats what we have for you today')");
                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(3,1, 'Another day, another set with some of our great exercises to help you reach a better version of yourself')");
                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(4,1, 'Lets burn those abdominals and lower body with some side leg raises and jumping jacks. You can do it!')");
                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(5,1, 'Feel free to rest today or if you feel like it you can check out our exercise set for today')");
                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(6,1, 'The week is almost over and your body might need to rest but if you want to you can finish your week with our full body exercise set')");

                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(0,2, 'Lets start your week working out your chest, a wide variaty of push-ups are awaiting you. You can do it!')");
                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(1,2, 'A full body exercise set is awaiting you, do your best!')");
                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(2,2, 'From squats to puch ups, this exercise set will be your challenge of the day')");
                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(3,2, 'Thursday? More like legday, got it? Jokes aside, believe in yourself you can do it!')");
                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(4,2, 'Friday will be a day full of core and leg exercises so warm up and go do it!')");
                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(5,2, 'Imagine climbing a mountain, this exercise wont feel that bad but we want you to be proud of yourself, a day full of exercises awaits you')");
                            db.execSQL("INSERT INTO DayWorkout(dayId,planId,description) VALUES(6,2, 'Here is a smaller exercise set to close out the week, remember to rest rest and respect your body')");

                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

}

