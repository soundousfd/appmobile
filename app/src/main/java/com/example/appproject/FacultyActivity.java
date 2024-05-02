package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacultyActivity extends AppCompatActivity {

    private boolean isEnglish = true;
    private boolean departmentsDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        LinearLayout parentLayout = findViewById(R.id.parentLayout);

        // JSON string containing the faculty data
        String json = "[{\"id_fac\":\"1\",\"name_fac\":\"Facult\\u00e9 des Droit et Sciences Politique\",\"name_fac_ar\":\"\\u0643\\u0644\\u064a\\u0629 \\u0627\\u0644\\u062d\\u0642\\u0648\\u0642 \\u0648 \\u0627\\u0644\\u0639\\u0644\\u0648\\u0645 \\u0627\\u0644\\u0633\\u064a\\u0627\\u0633\\u064a\\u0629\",\"AbrevFR\":\"FDSP\",\"AbrevAR\":\"\\u0643.\\u062d.\\u0639.\\u0633\",\"AbrevAng\":\"FLPS\",\"name_fac_en\":\"Droit et Sciences Politique\"},{\"id_fac\":\"2\",\"name_fac\":\"Facult\\u00e9 des Sciences et Technologie\",\"name_fac_ar\":\"\\u0643\\u0644\\u064a\\u0629 \\u0627\\u0644\\u0639\\u0644\\u0648\\u0645 \\u0648\\u0627\\u0644\\u062a\\u0643\\u0646\\u0648\\u0644\\u0648\\u062c\\u064a\\u0627\",\"AbrevFR\":\"FST\",\"AbrevAR\":\"\\u0643.\\u0639.\\u062a\",\"AbrevAng\":\"FST\",\"name_fac_en\":\"Sciences et Technologie\"},{\"id_fac\":\"3\",\"name_fac\":\"Facult\\u00e9 des sciences exectes et sciences de la natures et de la vie\",\"name_fac_ar\":\"\\u0643\\u0644\\u064a\\u0629 \\u0627\\u0644\\u0639\\u0644\\u0648\\u0645 \\u0627\\u0644\\u062f\\u0642\\u064a\\u0642\\u0629 \\u0648 \\u0639\\u0644\\u0648\\u0645 \\u0627\\u0644\\u0637\\u0628\\u064a\\u0639\\u0629 \\u0648 \\u0627\\u0644\\u062d\\u064a\\u0627\\u0629\",\"AbrevFR\":\"FSESNV\",\"AbrevAR\":\"\\u0643.\\u0639.\\u062f.\\u0639.\\u0637.\\u062d\",\"AbrevAng\":\"FESNLS\",\"name_fac_en\":\"sciences exectes et sciences de la natures et de la vie\"},{\"id_fac\":\"4\",\"name_fac\":\"Facult\\u00e9 des sciences humaines et sociales\",\"name_fac_ar\":\"\\u0643\\u0644\\u064a\\u0629 \\u0627\\u0644\\u0639\\u0644\\u0648\\u0645 \\u0627\\u0644\\u0627\\u0646\\u0633\\u0627\\u0646\\u064a\\u0629 \\u0648 \\u0627\\u0644\\u0627\\u062c\\u062a\\u0645\\u0627\\u0639\\u064a\\u0629\",\"AbrevFR\":\"FSHS\",\"AbrevAR\":\"\\u0643.\\u0639.\\u0627\\u0644\\u0627\\u0646\\u0633\\u0627\\u0646\\u064a\\u0629.\\u0627\\u0644\\u0627\\u062c\",\"AbrevAng\":\"FHSS\",\"name_fac_en\":\"sciences humaines et sociales\"},{\"id_fac\":\"5\",\"name_fac\":\"Institut des Sciences et Techniques des Activit\\u00e9s Physiques et Sportives\",\"name_fac_ar\":\"\\u0645\\u0639\\u0647\\u062f \\u0627\\u0644\\u0639\\u0644\\u0648\\u0645 \\u0648 \\u062a\\u0642\\u0646\\u064a\\u0627\\u062a \\u0627\\u0644\\u0646\\u0634\\u0627\\u0637\\u0627\\u062a \\u0627\\u0644\\u0628\\u062f\\u0646\\u064a\\u0629 \\u0648 \\u0627\\u0644\\u0631\\u064a\\u0627\\u0636\\u064a\\u0629\",\"AbrevFR\":\"ISTAPS\",\"AbrevAR\":\"\\u0645.\\u0627\\u0644\\u0631\\u064a\\u0627\\u0636\\u0629\",\"AbrevAng\":\"ISPORTS\",\"name_fac_en\":\"Sciences et Techniques des activit\\u00e9s physique et sportive \"},{\"id_fac\":\"6\",\"name_fac\":\"Facult\\u00e9 des sciences economiques commerciales et sciences de gestion \",\"name_fac_ar\":\"\\u0643\\u0644\\u064a\\u0629 \\u0627\\u0644\\u0639\\u0644\\u0648\\u0645 \\u0627\\u0644\\u0625\\u0642\\u062a\\u0635\\u0627\\u062f\\u064a\\u0629 \\u0648 \\u0627\\u0644\\u062a\\u062c\\u0627\\u0631\\u064a\\u0629 \\u0648 \\u0639\\u0644\\u0648\\u0645 \\u0627\\u0644\\u062a\\u0633\\u064a\\u064a\\u0631\",\"AbrevFR\":\"FSESCG\",\"AbrevAR\":\"\\u0643.\\u0639.\\u0627\\u0642\\u062a\\u0635\\u0627\\u062f\\u064a\\u0629\",\"AbrevAng\":\"FECMS\",\"name_fac_en\":\"sciences economiques commerciales et sciences de gestion \"},{\"id_fac\":\"7\",\"name_fac\":\"Facult\\u00e9 des Lettres et Langues \",\"name_fac_ar\":\"\\u0643\\u0644\\u064a\\u0629 \\u0627\\u0644\\u0627\\u062f\\u0627\\u0628 \\u0648 \\u0627\\u0644\\u0644\\u063a\\u0627\\u062a \\u0627\\u0644\\u0627\\u062c\\u0646\\u0628\\u064a\\u0629\",\"AbrevFR\":\"FLL\",\"AbrevAR\":\"\\u0643.\\u0627\\u0644\\u0627\\u062f\\u0627\\u0628.\\u0627\\u0644\\u0644\\u063a\\u0627\\u062a\",\"AbrevAng\":\"FLL\",\"name_fac_en\":\"Lettres et Langues \"},{\"id_fac\":\"8\",\"name_fac\":\"Annexe de m\\u00e9decine (Facult\\u00e9 de m\\u00e9decine Constantine 3)\",\"name_fac_ar\":\"\\u0645\\u0644\\u062d\\u0642\\u0629 \\u0643\\u0644\\u064a\\u0629 \\u0627\\u0644\\u0637\\u0628\",\"AbrevFR\":\"AFM\",\"AbrevAR\":\"\\u0645 \\u0643 \\u0637\",\"AbrevAng\":\"AFM\",\"name_fac_en\":\"Annexe de m\\u00e9decine (Facult\\u00e9 de m\\u00e9decine Constantine 3)\"}]";

        try {
            JSONArray jsonArray = new JSONArray(json);

            // Loop through the JSON array to read and display faculty names
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String facultyName = isEnglish ? jsonObject.getString("name_fac_en") : jsonObject.getString("name_fac_ar");

                // Create a new TextView and set its text to the faculty name
                TextView textView = new TextView(this);
                textView.setText(facultyName);

                // Set text properties
                textView.setTextSize(20);
                textView.setTypeface(null, Typeface.BOLD);
                textView.setPadding(16, 16, 16, 16);

                // Set gravity based on language direction
                if (isEnglish) {
                    textView.setGravity(Gravity.START);
                } else {
                    textView.setGravity(Gravity.END);
                }
                // Create layout params for the TextView
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(0, 16, 0, 16); // Add margins
                textView.setLayoutParams(params);

                // Set background drawable as border_background.xml
                textView.setBackground(ContextCompat.getDrawable(this, R.drawable.background));
                textView.setBackgroundResource(R.drawable.bord);

                // Add OnClickListener to faculty names
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Check if the clicked faculty name matches the desired one
                        if (facultyName.equals("sciences exectes et sciences de la natures et de la vie") && !departmentsDisplayed) {
                            // Remove other TextViews from the parent layout
                            parentLayout.removeAllViews();

                            // Add department names only if they have not been displayed yet
                            addDepartmentNames(parentLayout);

                            departmentsDisplayed = true;
                        }
                    }
                });


                // Add the TextView to the parent LinearLayout
                parentLayout.addView(textView);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Start animation for the existing TextView
        TextView textView = findViewById(R.id.textView);
        Animation topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        textView.startAnimation(topAnimation);
    }

    // Method to add department names to the layout
    // Method to add department names to the layout
    private void addDepartmentNames(LinearLayout parentLayout) {
        // Second JSON string containing additional department data
        String jsonDepartments = "[{\"id\":\"9\",\"name_fr\":\"Département des Sciences de la Terre et de l'Univers\",\"name_ar\":\"قسم علوم الأرض و الكون\"},{\"id\":\"10\",\"name_fr\":\"Département de Sciences de la Matière\",\"name_ar\":\"قسم علوم المادة\"},{\"id\":\"11\",\"name_fr\":\"Département de Sciences de la Nature et de la Vie\",\"name_ar\":\"قسم علوم الطبيعة و الحياة \"},{\"id\":\"12\",\"name_fr\":\"Département des Sciences Agronomiques\",\"name_ar\":\"قسم علوم فلاحية \"},{\"id\":\"13\",\"name_fr\":\"Département d'Informatique\",\"name_ar\":\"قسم الاعلام الالي\"},{\"id\":\"14\",\"name_fr\":\"Département de Mathématique\",\"name_ar\":\"قسم الرياضيات\"}]";

        try {
            JSONArray jsonDepartmentsArray = new JSONArray(jsonDepartments);

            // Loop through the JSON array to read and display department names
            for (int j = 0; j < jsonDepartmentsArray.length(); j++) {
                JSONObject departmentObject = jsonDepartmentsArray.getJSONObject(j);
                String departmentName = isEnglish ? departmentObject.getString("name_fr") : departmentObject.getString("name_ar");

                // Create a new LinearLayout to hold the department name and RadioButton
                LinearLayout departmentLayout = new LinearLayout(this);
                departmentLayout.setOrientation(LinearLayout.VERTICAL); // Change orientation to VERTICAL
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                layoutParams.setMargins(0, 16, 0, 16); // Add margins
                departmentLayout.setLayoutParams(layoutParams);
                departmentLayout.setBackgroundResource(R.drawable.border); // Set border background

                // Create a new TextView and set its text to the department name
                TextView departmentTextView = new TextView(this);
                departmentTextView.setText(departmentName);

                // Set text properties
                departmentTextView.setTextSize(15);
                departmentTextView.setTypeface(null, Typeface.BOLD);
                departmentTextView.setPadding(16, 8, 16, 8);

                // Set text color
                departmentTextView.setTextColor(ContextCompat.getColor(this, android.R.color.black));

                // Set gravity based on language direction
                if (isEnglish) {
                    departmentTextView.setGravity(Gravity.START);
                } else {
                    departmentTextView.setGravity(Gravity.END);
                }

                // Add the TextView to the department layout
                departmentLayout.addView(departmentTextView);

                // Create a new RadioButton
                RadioButton radioButton = new RadioButton(this);
                radioButton.setPadding(16, 8, 16, 8);

                // Add OnClickListener to the radio button for "Département d'Informatique"
                if (departmentName.equals("Département d'Informatique")) {
                    final JSONArray FormationArray = new JSONArray("[\n" +
                            "  {\n" +
                            "    \"id\": \"formation1\",\n" +
                            "    \"name_form\": \"Formation Académique\",\n" +
                            "    \"name_arab\": \"التكوين الأكاديمي\"\n" +
                            "  },\n" +
                            "  {\n" +
                            "    \"id\": \"formation2\",\n" +
                            "    \"name_form\": \"Formation Professionnelle\",\n" +
                            "    \"name_arab\": \"التكوين المهني\"\n" +
                            "  },\n" +
                            "  {\n" +
                            "    \"id\": \"formation3\",\n" +
                            "    \"name_form\": \"Formation (Ingénieur)\",\n" +
                            "    \"name_arab\": \"التكوين (مهندس)\"\n" +
                            "  }\n" +
                            "]");
                    radioButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Display specialty names when the radio button is clicked
                            displayFormationNames(FormationArray, parentLayout);
                        }
                    });
                }

                // Add the RadioButton to the department layout
                departmentLayout.addView(radioButton);

                // Add the department layout to the parent LinearLayout
                parentLayout.addView(departmentLayout);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    // Method to display specialty names
    // Method to display specialty names
    private void displayFormationNames(JSONArray FormationArray, LinearLayout parentLayout) {
        // Clear previous views
        parentLayout.removeAllViews();

        // Loop through the JSON array to read and display specialty names
        for (int i = 0; i < FormationArray.length(); i++) {
            try {
                JSONObject specialtyObject = FormationArray.getJSONObject(i);
                String FormationName = isEnglish ? specialtyObject.getString("name_form") : specialtyObject.getString("name_spec_ar");

                // Create a new LinearLayout to hold the Formation TextView and set its background
                LinearLayout formationLayout = new LinearLayout(this);
                formationLayout.setOrientation(LinearLayout.HORIZONTAL); // Set orientation to HORIZONTAL
                LinearLayout.LayoutParams formationLayoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                formationLayoutParams.setMargins(0, 8, 0, 8); // Add margins
                formationLayout.setLayoutParams(formationLayoutParams);
                formationLayout.setBackgroundResource(R.drawable.border); // Set border background

                // Create a new TextView for the Formation name
                TextView formationTextView = new TextView(this);
                formationTextView.setText(FormationName);
                formationTextView.setTextSize(15);
                formationTextView.setTypeface(null, Typeface.BOLD);
                formationTextView.setPadding(16, 8, 16, 8);
                formationTextView.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                formationTextView.setGravity(isEnglish ? Gravity.START : Gravity.END);

                // Add the TextView to the formation layout
                formationLayout.addView(formationTextView);

                // Add the formation layout to the parent layout
                parentLayout.addView(formationLayout);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
