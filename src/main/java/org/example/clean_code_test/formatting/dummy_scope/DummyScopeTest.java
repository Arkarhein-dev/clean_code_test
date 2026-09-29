package org.example.clean_code_test.formatting.dummy_scope;

import java.io.BufferedReader;
import java.io.IOException;

public class DummyScopeTest {
    // bad Code
    public void skipEmptyLines(BufferedReader reader) throws IOException {
        // Semicolon က while ရဲ့ နောက်ဆုံးမှာ တစ်န်းတည်း ကပ်ပါနေသည်
        while (reader.readLine().trim().isEmpty());

        // ဒီနေရာမှာ reader.readLine() က အမှန်တကယ် Loop ထဲမှာ အလုပ်လုပ်နေတယ်လို့
        // အလွယ်တကူ မှားထင်နိုင်ပြီး Semicolon လေးကို မြင်ဖို့ အရမ်းခက်ခဲပါတယ်
    }

    // Clean code designs
    public void skipEmptyLines2(BufferedReader reader) throws IOException {
        while (reader.readLine().trim().isEmpty())
        {
            // Semicolon ကို သီးသန့်လိုင်းပေါ်မှာ ထင်ရှားစွာ မြင်နိုင်စေရန် ပြုလုပ်ထားခြင်း
        }

    }

    public void skipEmptyLines3(BufferedReader reader) throws IOException {

        while (reader.readLine().trim().isEmpty())
            ; // Semicolon သီးသန့်လိုင်းခွဲထားခြင်းကြောင့် မျက်စိလည်စရာ မရှိတော့ပါ
    }

}
