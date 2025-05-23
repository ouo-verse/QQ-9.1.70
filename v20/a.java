package v20;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* compiled from: P */
    /* renamed from: v20.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C11387a extends TypeToken<List<Float>> {
        C11387a() {
        }
    }

    @TypeConverter
    public String a(List<Float> list) {
        return new Gson().toJson(list);
    }

    @TypeConverter
    public List<Float> b(String str) {
        return (List) new Gson().fromJson(str, new C11387a().getType());
    }
}
