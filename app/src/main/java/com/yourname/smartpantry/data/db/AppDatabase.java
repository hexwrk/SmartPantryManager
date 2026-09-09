package com.yourname.smartpantry.data.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.yourname.smartpantry.data.dao.PantryDao;
import com.yourname.smartpantry.data.dao.RecipeDao;
import com.yourname.smartpantry.data.entity.PantryItem;
import com.yourname.smartpantry.data.entity.Recipe;
import com.yourname.smartpantry.data.entity.RecipeIngredient;

import java.util.concurrent.Executors;

@Database(entities = {PantryItem.class, Recipe.class, RecipeIngredient.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PantryDao pantryDao();

    public abstract RecipeDao recipeDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context ctx) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    ctx.getApplicationContext(),
                                    AppDatabase.class, "pantry.db")
                            .addCallback(SEED_CALLBACK)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback SEED_CALLBACK = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Executors.newSingleThreadExecutor().execute(() -> {
                RecipeDao dao = INSTANCE.recipeDao();
                seedRecipe(dao, "Spaghetti Bolognese",
                        "1. Brown the beef mince in a hot pan.\n" +
                        "2. Add chopped onion and garlic, cook until soft.\n" +
                        "3. Stir in chopped tomatoes and tomato puree, simmer 20 minutes.\n" +
                        "4. Boil spaghetti until al dente, drain.\n" +
                        "5. Combine sauce with pasta and serve.",
                        new Object[][]{
                                {"Beef mince", 500, "g"},
                                {"Spaghetti", 400, "g"},
                                {"Onion", 1, "unit"},
                                {"Garlic", 2, "clove"},
                                {"Chopped tomatoes", 400, "g"}
                        });

                seedRecipe(dao, "Chicken Stir Fry",
                        "1. Slice chicken breast into strips and season.\n" +
                        "2. Heat oil in a wok, fry chicken until cooked through.\n" +
                        "3. Add sliced peppers and broccoli, stir fry 5 minutes.\n" +
                        "4. Add soy sauce and stir through.\n" +
                        "5. Serve over rice.",
                        new Object[][]{
                                {"Chicken breast", 400, "g"},
                                {"Bell pepper", 2, "unit"},
                                {"Broccoli", 200, "g"},
                                {"Soy sauce", 30, "ml"},
                                {"Rice", 300, "g"}
                        });

                seedRecipe(dao, "Vegetable Omelette",
                        "1. Whisk eggs with a splash of milk and season.\n" +
                        "2. Saute diced onion and pepper in butter.\n" +
                        "3. Pour in eggs and cook over medium heat.\n" +
                        "4. Fold in half once set and serve.",
                        new Object[][]{
                                {"Eggs", 3, "unit"},
                                {"Milk", 30, "ml"},
                                {"Onion", 1, "unit"},
                                {"Bell pepper", 1, "unit"},
                                {"Butter", 15, "g"}
                        });

                seedRecipe(dao, "Tomato Soup",
                        "1. Saute onion and garlic in olive oil until soft.\n" +
                        "2. Add chopped tomatoes and vegetable stock.\n" +
                        "3. Simmer 20 minutes.\n" +
                        "4. Blend until smooth and season to taste.",
                        new Object[][]{
                                {"Chopped tomatoes", 800, "g"},
                                {"Onion", 1, "unit"},
                                {"Garlic", 2, "clove"},
                                {"Vegetable stock", 500, "ml"},
                                {"Olive oil", 15, "ml"}
                        });

                seedRecipe(dao, "Beef Tacos",
                        "1. Brown beef mince with taco seasoning.\n" +
                        "2. Warm the taco shells.\n" +
                        "3. Fill shells with beef, lettuce, cheese and tomato.\n" +
                        "4. Serve with salsa.",
                        new Object[][]{
                                {"Beef mince", 400, "g"},
                                {"Taco shells", 8, "unit"},
                                {"Lettuce", 100, "g"},
                                {"Cheddar cheese", 100, "g"},
                                {"Tomato", 2, "unit"}
                        });

                seedRecipe(dao, "Margherita Pizza",
                        "1. Roll out pizza dough on a floured surface.\n" +
                        "2. Spread tomato sauce evenly.\n" +
                        "3. Top with sliced mozzarella and basil.\n" +
                        "4. Bake at 220C for 12 minutes.",
                        new Object[][]{
                                {"Pizza dough", 1, "unit"},
                                {"Tomato sauce", 150, "ml"},
                                {"Mozzarella", 200, "g"},
                                {"Basil", 10, "g"}
                        });

                seedRecipe(dao, "Chicken Curry",
                        "1. Fry diced onion, garlic and ginger until golden.\n" +
                        "2. Add curry powder and cook 1 minute.\n" +
                        "3. Add chicken thighs and coconut milk, simmer 25 minutes.\n" +
                        "4. Serve with rice.",
                        new Object[][]{
                                {"Chicken thighs", 500, "g"},
                                {"Onion", 1, "unit"},
                                {"Garlic", 2, "clove"},
                                {"Ginger", 10, "g"},
                                {"Coconut milk", 400, "ml"},
                                {"Curry powder", 15, "g"}
                        });

                seedRecipe(dao, "Greek Salad",
                        "1. Chop cucumber, tomato and red onion.\n" +
                        "2. Combine with olives and cubed feta.\n" +
                        "3. Dress with olive oil and oregano.",
                        new Object[][]{
                                {"Cucumber", 1, "unit"},
                                {"Tomato", 3, "unit"},
                                {"Red onion", 1, "unit"},
                                {"Feta cheese", 150, "g"},
                                {"Olives", 80, "g"},
                                {"Olive oil", 30, "ml"}
                        });

                seedRecipe(dao, "Banana Pancakes",
                        "1. Mash bananas and whisk with eggs and milk.\n" +
                        "2. Stir in flour until just combined.\n" +
                        "3. Fry spoonfuls of batter in butter until golden on each side.\n" +
                        "4. Serve with syrup.",
                        new Object[][]{
                                {"Banana", 2, "unit"},
                                {"Eggs", 2, "unit"},
                                {"Milk", 200, "ml"},
                                {"Flour", 150, "g"},
                                {"Butter", 20, "g"}
                        });

                seedRecipe(dao, "Lentil Dahl",
                        "1. Rinse red lentils.\n" +
                        "2. Fry onion, garlic and ginger until soft.\n" +
                        "3. Add lentils, turmeric and vegetable stock, simmer 20 minutes.\n" +
                        "4. Season and serve with rice or naan.",
                        new Object[][]{
                                {"Red lentils", 250, "g"},
                                {"Onion", 1, "unit"},
                                {"Garlic", 2, "clove"},
                                {"Ginger", 10, "g"},
                                {"Vegetable stock", 600, "ml"},
                                {"Turmeric", 5, "g"}
                        });

                seedRecipe(dao, "Fish and Chips",
                        "1. Cut potatoes into chips and parboil.\n" +
                        "2. Deep fry chips until golden.\n" +
                        "3. Coat cod fillets in batter and deep fry until crisp.\n" +
                        "4. Serve together with a wedge of lemon.",
                        new Object[][]{
                                {"Cod fillet", 400, "g"},
                                {"Potato", 600, "g"},
                                {"Flour", 100, "g"},
                                {"Lemon", 1, "unit"}
                        });

                seedRecipe(dao, "Mushroom Risotto",
                        "1. Fry sliced mushrooms in butter, set aside.\n" +
                        "2. Saute onion, add arborio rice and toast briefly.\n" +
                        "3. Add stock a ladle at a time, stirring until absorbed.\n" +
                        "4. Stir mushrooms and parmesan through, serve.",
                        new Object[][]{
                                {"Arborio rice", 300, "g"},
                                {"Mushrooms", 250, "g"},
                                {"Onion", 1, "unit"},
                                {"Vegetable stock", 800, "ml"},
                                {"Parmesan", 50, "g"},
                                {"Butter", 30, "g"}
                        });

                seedRecipe(dao, "BLT Sandwich",
                        "1. Fry bacon until crisp.\n" +
                        "2. Toast the bread.\n" +
                        "3. Layer bacon, lettuce and sliced tomato with mayonnaise.",
                        new Object[][]{
                                {"Bacon", 6, "rasher"},
                                {"Bread", 4, "slice"},
                                {"Lettuce", 50, "g"},
                                {"Tomato", 1, "unit"},
                                {"Mayonnaise", 20, "g"}
                        });

                seedRecipe(dao, "Vegetable Chili",
                        "1. Saute onion, garlic and pepper until soft.\n" +
                        "2. Add kidney beans, chopped tomatoes and chili powder.\n" +
                        "3. Simmer 25 minutes.\n" +
                        "4. Serve with rice.",
                        new Object[][]{
                                {"Kidney beans", 400, "g"},
                                {"Chopped tomatoes", 400, "g"},
                                {"Onion", 1, "unit"},
                                {"Bell pepper", 1, "unit"},
                                {"Garlic", 2, "clove"},
                                {"Chili powder", 10, "g"}
                        });

                seedRecipe(dao, "Caesar Salad",
                        "1. Tear romaine lettuce into a bowl.\n" +
                        "2. Toss with croutons, parmesan and Caesar dressing.\n" +
                        "3. Top with sliced grilled chicken.",
                        new Object[][]{
                                {"Romaine lettuce", 1, "unit"},
                                {"Chicken breast", 200, "g"},
                                {"Parmesan", 40, "g"},
                                {"Croutons", 60, "g"},
                                {"Caesar dressing", 40, "ml"}
                        });

                seedRecipe(dao, "Beef Stir Fry Noodles",
                        "1. Slice beef thinly and marinate in soy sauce.\n" +
                        "2. Stir fry beef until browned, set aside.\n" +
                        "3. Stir fry vegetables, then combine with beef and cooked noodles.\n" +
                        "4. Toss with soy and sesame oil.",
                        new Object[][]{
                                {"Beef strips", 350, "g"},
                                {"Egg noodles", 300, "g"},
                                {"Carrot", 2, "unit"},
                                {"Bell pepper", 1, "unit"},
                                {"Soy sauce", 40, "ml"}
                        });

                seedRecipe(dao, "Baked Salmon with Vegetables",
                        "1. Season salmon fillets and place on a tray with chopped vegetables.\n" +
                        "2. Drizzle with olive oil and lemon juice.\n" +
                        "3. Bake at 200C for 18 minutes.",
                        new Object[][]{
                                {"Salmon fillet", 4, "unit"},
                                {"Broccoli", 200, "g"},
                                {"Carrot", 2, "unit"},
                                {"Olive oil", 20, "ml"},
                                {"Lemon", 1, "unit"}
                        });

                seedRecipe(dao, "Pancetta Carbonara",
                        "1. Cook spaghetti until al dente.\n" +
                        "2. Fry pancetta until crisp.\n" +
                        "3. Whisk eggs with grated parmesan.\n" +
                        "4. Off the heat, combine pasta, pancetta and egg mixture, tossing quickly.",
                        new Object[][]{
                                {"Spaghetti", 400, "g"},
                                {"Pancetta", 150, "g"},
                                {"Eggs", 3, "unit"},
                                {"Parmesan", 60, "g"}
                        });

                seedRecipe(dao, "Apple Crumble",
                        "1. Peel and slice apples into a baking dish.\n" +
                        "2. Rub butter into flour and sugar to make a crumble.\n" +
                        "3. Sprinkle crumble over apples.\n" +
                        "4. Bake at 180C for 30 minutes.",
                        new Object[][]{
                                {"Apple", 5, "unit"},
                                {"Flour", 150, "g"},
                                {"Butter", 100, "g"},
                                {"Sugar", 80, "g"}
                        });
            });
        }
    };

    private static void seedRecipe(RecipeDao dao, String name, String steps, Object[][] ingredients) {
        long recipeId = dao.insertRecipe(new Recipe(name, steps));
        for (Object[] ingredient : ingredients) {
            dao.insertIngredient(new RecipeIngredient(
                    (int) recipeId,
                    (String) ingredient[0],
                    (int) ingredient[1],
                    (String) ingredient[2]));
        }
    }
}
