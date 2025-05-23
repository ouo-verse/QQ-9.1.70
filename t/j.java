package t;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, List<i>> f435104c;

    /* renamed from: d, reason: collision with root package name */
    private volatile Map<String, String> f435105d;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        private static final String f435106d;

        /* renamed from: e, reason: collision with root package name */
        private static final Map<String, List<i>> f435107e;

        /* renamed from: a, reason: collision with root package name */
        private boolean f435108a = true;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, List<i>> f435109b = f435107e;

        /* renamed from: c, reason: collision with root package name */
        private boolean f435110c = true;

        static {
            String b16 = b();
            f435106d = b16;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b16)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(b16)));
            }
            f435107e = Collections.unmodifiableMap(hashMap);
        }

        @VisibleForTesting
        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb5 = new StringBuilder(property.length());
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = property.charAt(i3);
                if ((charAt > 31 || charAt == '\t') && charAt < '\u007f') {
                    sb5.append(charAt);
                } else {
                    sb5.append('?');
                }
            }
            return sb5.toString();
        }

        public j a() {
            this.f435108a = true;
            return new j(this.f435109b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static final class b implements i {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final String f435111a;

        b(@NonNull String str) {
            this.f435111a = str;
        }

        @Override // t.i
        public String a() {
            return this.f435111a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f435111a.equals(((b) obj).f435111a);
            }
            return false;
        }

        public int hashCode() {
            return this.f435111a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f435111a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.f435104c = Collections.unmodifiableMap(map);
    }

    @NonNull
    private String a(@NonNull List<i> list) {
        StringBuilder sb5 = new StringBuilder();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            String a16 = list.get(i3).a();
            if (!TextUtils.isEmpty(a16)) {
                sb5.append(a16);
                if (i3 != list.size() - 1) {
                    sb5.append(',');
                }
            }
        }
        return sb5.toString();
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f435104c.entrySet()) {
            String a16 = a(entry.getValue());
            if (!TextUtils.isEmpty(a16)) {
                hashMap.put(entry.getKey(), a16);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f435104c.equals(((j) obj).f435104c);
        }
        return false;
    }

    @Override // t.h
    public Map<String, String> getHeaders() {
        if (this.f435105d == null) {
            synchronized (this) {
                if (this.f435105d == null) {
                    this.f435105d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f435105d;
    }

    public int hashCode() {
        return this.f435104c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f435104c + '}';
    }
}
