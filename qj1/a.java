package qj1;

import android.net.Uri;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPBusinessCard;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStBusinessCard;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b#\u0010'B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020(\u00a2\u0006\u0004\b#\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\bR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u0010\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b!\u0010\u0015\u00a8\u0006*"}, d2 = {"Lqj1/a;", "", "", "g", "other", "", "equals", "a", "", "c", "Z", "getNeedShow", "()Z", "setNeedShow", "(Z)V", "needShow", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", QZoneDTLoginReporter.SCHEMA, "", "I", "f", "()I", "setWidth", "(I)V", "width", "d", "setHeight", "height", "setModuleId", "moduleId", "<init>", "()V", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStBusinessCard;", "busiCard", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStBusinessCard;)V", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPBusinessCard;", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPBusinessCard;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean needShow;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String schema;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int height;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String moduleId;

    public a() {
        this.schema = "";
        this.moduleId = "";
    }

    private final void g() {
        boolean z16;
        if (this.schema.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String queryParameter = Uri.parse(this.schema).getQueryParameter("sp_id");
            if (queryParameter == null) {
                queryParameter = "";
            }
            this.moduleId = queryParameter;
        }
    }

    public final boolean a() {
        boolean z16;
        if (!this.needShow || this.height <= 0 || this.width <= 0) {
            return false;
        }
        if (this.schema.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    /* renamed from: b, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String c() {
        String str = "BusinessCardInfo needShow = " + this.needShow + ", width = " + this.width + ", height = " + this.height + ", schema = " + this.schema;
        Intrinsics.checkNotNullExpressionValue(str, "stringBuilder.toString()");
        return str;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getModuleId() {
        return this.moduleId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getSchema() {
        return this.schema;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.needShow == aVar.needShow && Intrinsics.areEqual(this.schema, aVar.schema) && this.width == aVar.width && this.height == aVar.height) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull GProStBusinessCard busiCard) {
        this();
        Intrinsics.checkNotNullParameter(busiCard, "busiCard");
        this.needShow = busiCard.needShow;
        String str = busiCard.jumpSchemaUrl;
        Intrinsics.checkNotNullExpressionValue(str, "busiCard.jumpSchemaUrl");
        this.schema = str;
        this.width = busiCard.width;
        this.height = busiCard.height;
        g();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull IGProMVPBusinessCard busiCard) {
        this();
        Intrinsics.checkNotNullParameter(busiCard, "busiCard");
        this.needShow = busiCard.getHasCard();
    }
}
