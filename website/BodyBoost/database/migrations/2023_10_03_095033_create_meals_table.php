<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('meals', function (Blueprint $table) {
            $table->id();
            $table->string('name');
            $table->foreignId('dietary_types_id')->constrained()->cascadeOnDelete();
            $table->foreignId('meal_types_id')->constrained()->cascadeOnDelete();
            $table->string('excerpt');
            $table->text('recipe');
            $table->decimal('prep_time', 5, 2);
            $table->decimal('cook_time', 5, 2);
            $table->integer('servings');
            $table->integer('calories');
            $table->string('thumbnail');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('meals');
    }
};
