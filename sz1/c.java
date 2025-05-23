package sz1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.AppSetting;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import r12.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\u000f"}, d2 = {"Lsz1/c;", "", "Landroid/content/Context;", "context", "", "guildId", "Landroid/text/SpannableStringBuilder;", "c", "Landroid/app/Activity;", "", "d", "prefix", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f435021a = new c();

    c() {
    }

    @JvmStatic
    @NotNull
    public static final SpannableStringBuilder c(@NotNull Context context, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        IGuildSpeakableThresholdPermission f16 = d.f(guildId);
        int directMsgLimitType = f16.getDirectMsgLimitType();
        if (directMsgLimitType != 2) {
            if (directMsgLimitType != 4) {
                return new SpannableStringBuilder("");
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = context.getString(R.string.f157341mn);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026d_profile_card_join_time)");
            String format = String.format(string, Arrays.copyOf(new Object[]{JoinTimeItem.INSTANCE.b(f16.getDirectMsgLimitTime())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return new SpannableStringBuilder(format);
        }
        c cVar = f435021a;
        String string2 = context.getString(R.string.f157331mm);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026d_profile_card_face_auth)");
        return cVar.b(context, string2);
    }

    @JvmStatic
    public static final void d(@NotNull final Activity context, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        final IGuildSpeakableThresholdPermission f16 = d.f(guildId);
        int guildLimitType = f16.getGuildLimitType();
        if (guildLimitType != 2) {
            if (guildLimitType != 4) {
                if (AppSetting.isPublicVersion()) {
                    QLog.i("Guild.sr.SpeakThresholdHelper", 1, "illegal limit type");
                    return;
                }
                throw new IllegalArgumentException("illegal limit type");
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = context.getString(R.string.f157281mh);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026hreshold_audio_join_time)");
            String format = String.format(string, Arrays.copyOf(new Object[]{JoinTimeItem.INSTANCE.b(f16.getGuildLimitTime())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QQToast.makeText(context, format, 0).show();
            return;
        }
        r12.a.a(context, new a.C11105a(context.getString(R.string.f157201m_), context.getString(R.string.f157191m9), new View.OnClickListener() { // from class: sz1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.e(context, f16, view);
            }
        })).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Activity context, IGuildSpeakableThresholdPermission permission, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(permission, "$permission");
        QLog.i("Guild.sr.SpeakThresholdHelper", 1, "handleAuthClick");
        ch.i1(context, permission.getVerifyUrl());
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final SpannableStringBuilder b(@NotNull Context context, @NotNull String prefix) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(prefix + " ");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#0099FF")), spannableStringBuilder.length() + (-4), spannableStringBuilder.length() + (-1), 17);
        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.guild_assistant_list_item_arrow, null);
        if (drawable != null) {
            drawable.setBounds(QQGuildUIUtil.f(2.0f), QQGuildUIUtil.f(-1.0f), QQGuildUIUtil.f(8.0f), QQGuildUIUtil.f(9.0f));
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(drawable), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        throw new NullPointerException("Guild.sr.SpeakThresholdHelper guild_assistant_list_item_arrow is null");
    }
}
