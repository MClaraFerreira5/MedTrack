/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,js,jsx,ts,tsx}"
  ],
  theme: {
    extend: {
      colors: {
        turquoise: "#40E0D0", // Define "turquoise" no Tailwind
      },
    },
  },
  plugins: [],
}

