# Day 3: Mull It Over

> "Our computers are having issues, so I have no idea if we have any Chief Historians in stock! You're welcome to check the warehouse, though," says the mildly flustered shopkeeper at the North Pole Toboggan Rental Shop. The Historians head out to take a look.

The shopkeeper turns to you.  
"Any chance you can see why our computers are having issues again?"

The computer appears to be trying to run a program, but its memory (your puzzle input) is corrupted. All of the instructions have been jumbled up!

It seems like the goal of the program is just to multiply some numbers. It does that with instructions like `mul(X,Y)`, where `X` and `Y` are each 1 to 3 digit numbers. For instance:

- `mul(44,46)` → 44 × 46 = 2024  
- `mul(123,4)` → 123 × 4 = 492

However, because the program's memory has been corrupted, there are also many invalid characters that should be ignored, even if they look like part of a `mul` instruction. Sequences like:

- `mul(4*`
- `mul(6,9!`
- `?(12,34)`
- `mul ( 2 , 4 )`

…do nothing and must be ignored.

---

## Example Input:

```

xmul(2,4)%\&mul\[3,7]!@^do\_not\_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))

```

Only the **four valid** `mul(X,Y)` instructions are:

- `mul(2,4)` → 8
- `mul(5,5)` → 25
- `mul(11,8)` → 88
- `mul(8,5)` → 40

**Total:** 8 + 25 + 88 + 40 = **161**

---

### ✅ Your Part One Answer: `174561379`

---

# Part Two

As you scan through the corrupted memory, you notice that some of the conditional statements are also still intact.  
If you handle some of the uncorrupted conditional statements in the program, you might be able to get an even more accurate result.

There are two new instructions you'll need to handle:

- `do()` → **enables** future `mul` instructions  
- `don't()` → **disables** future `mul` instructions

Only the **most recent** `do()` or `don't()` applies.  
By default, `mul` instructions are enabled at the beginning.

---

## Updated Example Input:

```

xmul(2,4)\&mul\[3,7]!^don't()\_mul(5,5)+mul(32,64]\(mul(11,8)undo()?mul(8,5))

```

Here:

- `mul(2,4)` → Enabled → 8
- `mul(5,5)` → Disabled (after `don't()`) → Ignored
- `mul(11,8)` → Disabled → Ignored
- `mul(8,5)` → Enabled again (after `do()`) → 40

**Total:** 8 + 40 = **48**

---

### ✅ Your Part Two Answer: `106921067`

---

🎉 Both parts of this puzzle are complete! You have earned two gold stars: **⭐️⭐️**

Solutions: [Day3.scala](../src/main/scala/Day3.scala)

Inputs: [inputDay3.txt](../input/inputDay3.txt)
