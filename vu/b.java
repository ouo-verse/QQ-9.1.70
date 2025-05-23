package vu;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements SharedPreferences {

    /* renamed from: d, reason: collision with root package name */
    private final SharedPreferences f443508d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f443509e;

    /* renamed from: f, reason: collision with root package name */
    private final String f443510f;

    /* renamed from: h, reason: collision with root package name */
    private final String f443511h;

    public b(@NonNull SharedPreferences sharedPreferences, String str, @NonNull String str2, boolean z16) {
        this.f443508d = sharedPreferences;
        this.f443509e = z16;
        this.f443510f = str;
        this.f443511h = str2;
    }

    @Override // android.content.SharedPreferences
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c edit() {
        return new c(this.f443508d.edit(), this.f443510f, this.f443511h, this.f443509e);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f443508d.contains(str);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f443508d.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        return this.f443508d.getBoolean(str, z16);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        return this.f443508d.getFloat(str, f16);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        return this.f443508d.getInt(str, i3);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        return this.f443508d.getLong(str, j3);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.f443508d.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f443508d.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f443508d.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f443508d.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
