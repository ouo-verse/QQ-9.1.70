package zd4;

import com.tencent.tavcut.core.render.LightAiManagerKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.MovieConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lzd4/c;", "", "", "agent", "path", "", "a", "Lorg/light/MovieConfig;", "movieConfig", "d", "b", "c", "", "Ljava/util/Map;", "agentPath", "agentLevel", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f452391c = new c();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, String> agentPath = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, String> agentLevel = new LinkedHashMap();

    c() {
    }

    public final void a(@NotNull String agent, @NotNull String path) {
        Intrinsics.checkParameterIsNotNull(agent, "agent");
        Intrinsics.checkParameterIsNotNull(path, "path");
        agentPath.put(agent, path);
    }

    public final void b(@Nullable MovieConfig movieConfig) {
        for (Map.Entry<String, String> entry : agentPath.entrySet()) {
            ee4.b.a(LightAiManagerKt.TAG, "setup3DAgentPath ai path set agentName: " + entry.getKey() + " agentPath: " + entry.getValue());
            if (Intrinsics.areEqual("Ace_3d_Engine", entry.getKey())) {
                Map<String, String> map = agentLevel;
                if (map.containsKey(entry.getKey())) {
                    if (movieConfig != null) {
                        movieConfig.setLightAIModelPath(entry.getValue(), entry.getKey(), map.get(entry.getKey()));
                        return;
                    }
                    return;
                } else {
                    if (movieConfig != null) {
                        movieConfig.setLightAIModelPath(entry.getValue(), entry.getKey());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void c(@Nullable MovieConfig movieConfig) {
        for (Map.Entry<String, String> entry : agentPath.entrySet()) {
            ee4.b.a(LightAiManagerKt.TAG, "ai path set agentName: " + entry.getKey() + " agentPath: " + entry.getValue());
            Map<String, String> map = agentLevel;
            if (map.containsKey(entry.getKey())) {
                if (movieConfig != null) {
                    movieConfig.setLightAIModelPath(entry.getValue(), entry.getKey(), map.get(entry.getKey()));
                }
            } else if (movieConfig != null) {
                movieConfig.setLightAIModelPath(entry.getValue(), entry.getKey());
            }
        }
    }

    public final void d(@NotNull MovieConfig movieConfig) {
        Intrinsics.checkParameterIsNotNull(movieConfig, "movieConfig");
        movieConfig.setSyncMode(true);
        movieConfig.setDetectShorterEdgeLength(180, "");
        movieConfig.setBGMusicHidden(false);
    }
}
