package uq3;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.qmmkv.MMKVAdapter;
import java.util.Map;
import java.util.Set;
import uq3.k;

/* compiled from: P */
/* loaded from: classes22.dex */
public class m implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: d, reason: collision with root package name */
    private final SharedPreferences f439816d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f439817e;

    /* renamed from: f, reason: collision with root package name */
    private MMKVAdapter f439818f;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final k.c f439819h;

    public m(@NonNull SharedPreferences sharedPreferences, @NonNull String str, boolean z16, boolean z17) {
        this.f439816d = sharedPreferences;
        this.f439817e = z16;
        if (!z16) {
            this.f439818f = j.a(RFWApplication.getApplication(), str);
        }
        if (z17) {
            this.f439819h = new k.a();
        } else {
            this.f439819h = new k.b();
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.f439816d.edit().apply();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        return this.f439816d.edit().clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.f439816d.edit().commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f439816d.contains(this.f439819h.getKey(str));
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f439816d.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        return this.f439816d.getBoolean(this.f439819h.getKey(str), z16);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        return this.f439816d.getFloat(this.f439819h.getKey(str), f16);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        return this.f439816d.getInt(this.f439819h.getKey(str), i3);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        return this.f439816d.getLong(this.f439819h.getKey(str), j3);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.f439816d.getString(this.f439819h.getKey(str), str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f439816d.getStringSet(this.f439819h.getKey(str), set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z16) {
        String key = this.f439819h.getKey(str);
        if (!this.f439817e) {
            this.f439818f.putBoolean(key, z16);
        }
        return this.f439816d.edit().putBoolean(key, z16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f16) {
        String key = this.f439819h.getKey(str);
        if (!this.f439817e) {
            this.f439818f.putFloat(key, f16);
        }
        return this.f439816d.edit().putFloat(key, f16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i3) {
        String key = this.f439819h.getKey(str);
        if (!this.f439817e) {
            this.f439818f.putInt(key, i3);
        }
        return this.f439816d.edit().putInt(key, i3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j3) {
        String key = this.f439819h.getKey(str);
        if (!this.f439817e) {
            this.f439818f.putLong(key, j3);
        }
        return this.f439816d.edit().putLong(key, j3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        String key = this.f439819h.getKey(str);
        if (!this.f439817e) {
            this.f439818f.putString(key, str2);
        }
        return this.f439816d.edit().putString(key, str2);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        String key = this.f439819h.getKey(str);
        if (!this.f439817e) {
            this.f439818f.putStringSet(key, set);
        }
        return this.f439816d.edit().putStringSet(key, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f439816d.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        String key = this.f439819h.getKey(str);
        if (!this.f439817e) {
            this.f439818f.remove(key);
        }
        return this.f439816d.edit().remove(key);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f439816d.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }
}
