package x71;

import com.tencent.mobileqq.aio.animation.GuildAIOAnimationMsgProcessorFactory;
import com.tencent.qqnt.aio.data.AIOMsgProcessorFactory;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static ArrayList<AIOMsgProcessorFactory> f447392a = new ArrayList<>();

    static {
        a();
    }

    private static void a() {
        f447392a.add(new GuildAIOAnimationMsgProcessorFactory());
    }
}
