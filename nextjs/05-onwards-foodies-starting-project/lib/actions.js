"use server";

import { redirect } from "next/navigation";
import { saveMeal } from "./meals";
import { revalidatePath } from "next/cache";

function isInvalidText(text) {
  return !text || text.trim() === "";
}

function isInvalidEmail(email) {
  return isInvalidText(email) || !meal.creator_email.inclues("@");
}

function isInvalidImage(image) {
  return !image || image.size === 0;
}

function isInvalidMeal(meal) {
  return (
    isInvalidText(meal.title) ||
    isInvalidText(meal.summary) ||
    isInvalidText(meal.instructions) ||
    isInvalidText(meal.creator) ||
    isInvalidText(meal.creator_email) ||
    isInvalidEmail(meal.creator_email) ||
    isInvalidImage(meal.image)
  );
}

export async function shareMeal(prevState, formData) {
  const meal = {
    title: formData.get("title"),
    image: formData.get("image"),
    summary: formData.get("summary"),
    instructions: formData.get("instructions"),
    creator: formData.get("name"),
    creator_email: formData.get("email"),
  };

  if (isInvalidMeal(meal)) {
    return { message: "Invalid input." };
  }

  await saveMeal(meal);
  revalidatePath("/meals");
  redirect("/meals");
}
