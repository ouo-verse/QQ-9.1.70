package y53;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes21.dex */
public class f implements SharedPreferences {

    /* renamed from: d, reason: collision with root package name */
    private final SharedPreferences f449485d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f449486e;

    /* renamed from: f, reason: collision with root package name */
    private final String f449487f;

    public f(@NonNull SharedPreferences sharedPreferences, @NonNull String str, boolean z16) {
        this.f449485d = sharedPreferences;
        this.f449486e = z16;
        this.f449487f = str;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f449485d.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new g(this.f449485d.edit(), this.f449487f, this.f449486e);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f449485d.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        return this.f449485d.getBoolean(str, z16);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        return this.f449485d.getFloat(str, f16);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        return this.f449485d.getInt(str, i3);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        return this.f449485d.getLong(str, j3);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.f449485d.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f449485d.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f449485d.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f449485d.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
