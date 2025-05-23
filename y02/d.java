package y02;

import android.util.Log;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Ly02/d;", "", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f449221a = new d();

    d() {
    }

    @JvmStatic
    public static final int a() {
        int i3;
        if (a.a("exp_sgrp_bottomtab_bagde", "exp_sgrp_bottomtab_bagde_B")) {
            i3 = 0;
        } else if (a.a("exp_sgrp_bottomtab_bagde", "exp_sgrp_bottomtab_bagde_C")) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        a.d("exp_sgrp_bottomtab_bagde");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.tab.GuildTabRedABTestUtils", "getTabGrayRedShowCount redCount=" + i3);
        }
        return i3;
    }
}
