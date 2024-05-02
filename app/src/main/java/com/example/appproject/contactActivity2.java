package com.example.appproject;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class contactActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact2);

        // Array of email addresses
        String[] emailAddresses = {
                "\"Ababsa Tarek\n<tarek.ababsa@univ-biskra.dz>\"",
                "\"Abdelli Belkacem\n<abdelli.belkacem@univ-biskra.dz>\"",
                "\"Almi Moufida\n<moufida.almi@univ-biskra.dz>\"",
                "\"Aloui Ahmed\n<a.aloui@univ-biskra.dz>\"",
                "\"Ayad Soheyb\n<s.ayad@univ-biskra.dz>\"",
                "\"Babahenini Djihane\n<djihane.babahenini@univ-biskra.dz>\"",
                "\"Babahenini Mohamed Chaouki\n<mc.babahenini@univ-biskra.dz>\"",
                "\"Bachir Abdelmalik\n<abdelmalik.bachir@univ-biskra.dz>\"",
                "\"Bahi Naima\n<n.bahi@univ-biskra.dz>\"",
                "\"Belaiche Hamza\n<hamza.belaiche@univ-biskra.dz>\"",
                "\"Belouaar Houcine\n<houcine.belouaar@univ-biskra.dz>\"",
                "\"Belounnar Saliha\n<saliha.belounnar@univ-biskra.dz>\"",
                "\"Ben Dahmene Asma\n<asma.bendahmene@univ-biskra.dz>\"",
                "\"Benameur Sabrina\n<sabrina.benameur@univ-biskra.dz>\"",
                "\"Benchabane Moufida\n<m.benchabane@univ-biskra.dz>\"",
                "\"Bendahmane Toufik\n<toufik.bendahmane@univ-biskra.dz>\"",
                "\"Bennoui Hammadi\n<h.bennoui@univ-biskra.dz>\"",
                "\"Benseghier Nadia\n<nadia.benseghier@univ-biskra.dz>\"",
                "\"Berghida Meryem\n<Meryem.berghida@univ-biskra.dz>\"",
                "\"Berima Salima\n<salima.berima@univ-biskra.dz>\"",
                "\"Bitam Salim\n<s.bitam@univ-biskra.dz>\"",
                "\"Boucetta Mebarek\n<mebarek.boucetta@univ-biskra.dz>\"",
                "\"Bouchana Belkacem\n<belkacem.bouchana@univ-biskra.dz>\"",
                "\"Bouguetitiche Amina\n<amina.bouguetitiche@univ-biskra.dz>\"",
                "\"Boukhlouf Djemaa\n<djemaa.boukhlouf@univ-biskra.dz>\"",
                "\"Bourekkache Samir\n<s.bourekkache@univ-biskra.dz>\"",
                "\"Cherif Foudil\n<cherif.foudil@univ-biskra.dz>\"",
                "\"Chighoub Fouzia\n<fouzia.chighoub@univ-biskra.dz>\"",
                "\"Chighoub Rabiaa\n<rabiaa.chighoub@univ-biskra.dz>\"",
                "\"Djaber Khaled\n<khaled.djaber@univ-biskra.dz>\"",
                "\"Djedi Noureddine\n<n.djedi@univ-biskra.dz>\"",
                "\"Djeffal Abdelhamid\n<a.djeffal@univ-biskra.dz>\"",
                "\"Djerou Leila\n<l.djerou@univ-biskra.dz>\"",
                "\"Fekraoui Farah\n<Farah.fekraoui@univ-biskra.dz>\"",
                "\"Guemeida Abdelbasset\n<abdelbasset.guemeida@univ-biskra.dz>\"",
                "\"Guerrouf Faycal\n<f.guerrouf@univ-biskra.dz>\"",
                "\"Hamida Ammar\n<ammar.hamida@univ-biskra.dz>\"",
                "\"Hattab Dalila\n<d.hattab@univ-biskra.dz>\"",
                "\"Hmidi Zohra\n<zohra.hmidi@univ-biskra.dz>\"",
                "\"Hoadjli Hadia\n<hoadjli.hadia@univ-biskra.dz>\"",
                "\"Houhou Okba\n<okba.houhou@univ-biskra.dz>\"",
                "\"Kahloul Laid\n<l.kahloul@univ-biskra.dz>\"",
                "\"Kalfali Toufik\n<toufik.kalfali@univ-biskra.dz>\"",
                "\"Kazar Okba\n<o.kazar@univ-biskra.dz>\"",
                "\"Kerdoudi Mohamed Lamine\n<l.kerdoudi@univ-biskra.dz>\"",
                "\"Meadi Mohamed Nadjib\n<mohamed_nadjib.meadi@univ-biskra.dz>\"",
                "\"Meklid Abdessalam\n<abdessalam.meklid@univ-biskra.dz>\"",
                "\"Merabet Rabiya\n<rabiya.merabet@univ-biskra.dz>\"",
                "\"Merizig Abdelhak\n<a.merizig@univ-biskra.dz>\"",
                "\"Mohammedi Amira\n<amira.mohammedi@univ-biskra.dz>\"",
                "\"Mokhtari Bilal\n<bilal.mokhtari@univ-biskra.dz>\"",
                "\"Mouaki Benani Nawel\n<nawel.mouaki@univ-biskra.dz>\"",
                "\"Moussaoui Manel\n<manel.moussaoui@univ-biskra.dz>\"",
                "\"Ouaar Hanane\n<hanane.ouaar@univ-biskra.dz>\"",
                "\"Rahmani Salima\n<s.rahmani@univ-biskra.dz>\"",
                "\"Rezeg Khaled\n<k.rezeg@univ-biskra.dz>\"",
                "\"Sahli Siham\n<siham.sahli@univ-biskra.dz>\"",
                "\"Sahraoui Somia\n<somia.sahraoui@univ-biskra.dz>\"",
                "\"Sihem Slatnia\n<sihem.slatnia@univ-biskra.dz>\"",
                "\"Telli Abdelmoutie\n<a.telli@univ-biskra.dz>\"",
                "\"Terrissa Sadek labib\n<terrissa@univ-biskra.dz>\"",
                "\"Tibermacine Ahmed\n<ahmed.tibermacine@univ-biskra.dz>\"",
                "\"Tibermacine Okba\n<o.tibermacine@univ-biskra.dz>\"",
                "\"Tigane Samir\n<s.tigane@univ-biskra.dz>\"",
                "\"Torki Fatima Zohra\n<fatima.torki@univ-biskra.dz>\"",
                "\"Touil Keltoum\n<keltoum.touil@univ-biskra.dz>\"",
                "\"Youkana Imene\n<imane.youkana@univ-biskra.dz>\"",
                "\"Zerari Abdelmoumen\n<a.zerari@univ-biskra.dz>\"",
                "\"Zerarka Mohamed Faouzi\n<faouzi.zerarka@univ-biskra.dz>\"",
                "\"Zernadji Tarek\n<tarek.zernadji@univ-biskra.dz>\"",
                "\"Zouioueche Amina\n<amina.zouioueche@univ-biskra.dz>\""
        };

        LinearLayout layout = findViewById(R.id.layout);

        for (String email : emailAddresses) {
            LinearLayout row = new LinearLayout(this);
            row.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            row.setOrientation(LinearLayout.HORIZONTAL);
            layout.addView(row);

            // Add black-bordered LinearLayout
            LinearLayout emailLayout = new LinearLayout(this);
            emailLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1.0f
            ));
            emailLayout.setBackground(getResources().getDrawable(R.drawable.border)); // Set black border
            emailLayout.setPadding(10, 10, 10, 10); // Add padding to the bordered layout

            TextView textView = new TextView(this);
            textView.setText(email);
            textView.setTextSize(20);
            textView.setTextColor(getResources().getColor(R.color.black));
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            textView.setPadding(0, 0, 20, 0); // Add right padding to create space for the button
            textView.setClickable(true); // Make the TextView clickable
            textView.setMovementMethod(LinkMovementMethod.getInstance()); // Enable text selection
            emailLayout.addView(textView); // Add TextView to bordered layout
            row.addView(emailLayout); // Add bordered layout to row

            // Add a "Copy" button next to each email address
            Button copyButton = new Button(this);
            copyButton.setText("Copy");
            copyButton.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            copyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String emailAddress = email.split("\n")[1]; // Get the email address from the text
                    copyToClipboard(emailAddress);
                }
            });
            row.addView(copyButton);
        }
    }

    private void copyToClipboard(String text) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("Email", text);
        clipboardManager.setPrimaryClip(clipData);
    }
}
