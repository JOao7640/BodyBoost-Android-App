<?php

namespace App\Models;

use App\Models\Exercise;
use App\Models\WorkoutPlan;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class ExerciseSet extends Model
{
    use HasFactory;

    protected $guarded = [];

    public function exercises()
    {
        return $this->belongsTo(Exercise::class, 'exercise_id');
    }

    public function workoutPlan()
    {
        return $this->belongsTo(WorkoutPlan::class);
    }
}
