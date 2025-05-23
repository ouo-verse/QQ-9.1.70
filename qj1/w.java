package qj1;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b\u001c\u0010 B\u0011\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020!\u00a2\u0006\u0004\b\u001c\u0010\"J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0017\u0010\nR\"\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0007\u001a\u0004\b\f\u0010\b\"\u0004\b\u001a\u0010\n\u00a8\u0006#"}, d2 = {"Lqj1/w;", "", "other", "", "equals", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setDocJumpUrl", "(Ljava/lang/String;)V", "docJumpUrl", "b", "e", "setUrl", "url", "c", "d", "setTitle", "title", "getIcon", "setIcon", "icon", "setPlatformName", "platformName", "f", "setPermission", QCircleDaTongConstant.ElementParamValue.PERMISSION, "<init>", "()V", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPRichTextContent;", "content", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPRichTextContent;)V", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String docJumpUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String icon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String platformName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String permission;

    public w() {
        this.docJumpUrl = "";
        this.url = "";
        this.title = "";
        this.icon = "";
        this.platformName = "";
        this.permission = "";
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDocJumpUrl() {
        return this.docJumpUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPermission() {
        return this.permission;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPlatformName() {
        return this.platformName;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof w)) {
            return false;
        }
        w wVar = (w) other;
        if (Intrinsics.areEqual(this.docJumpUrl, wVar.docJumpUrl) && Intrinsics.areEqual(this.icon, wVar.icon) && Intrinsics.areEqual(this.url, wVar.url) && Intrinsics.areEqual(this.permission, wVar.permission) && Intrinsics.areEqual(this.title, wVar.title) && Intrinsics.areEqual(this.platformName, wVar.platformName)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w(@NotNull IGProMVPRichTextContent content) {
        this();
        Intrinsics.checkNotNullParameter(content, "content");
        String url = content.getUrlContent().getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "content.urlContent.url");
        this.docJumpUrl = url;
        String icon = content.getUrlContent().getTencentDocsContent().getIcon();
        Intrinsics.checkNotNullExpressionValue(icon, "content.urlContent.tencentDocsContent.icon");
        this.icon = icon;
        String url2 = content.getUrlContent().getTencentDocsContent().getUrl();
        Intrinsics.checkNotNullExpressionValue(url2, "content.urlContent.tencentDocsContent.url");
        this.url = url2;
        String permission = content.getUrlContent().getTencentDocsContent().getPermission();
        Intrinsics.checkNotNullExpressionValue(permission, "content.urlContent.tencentDocsContent.permission");
        this.permission = permission;
        String title = content.getUrlContent().getTencentDocsContent().getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "content.urlContent.tencentDocsContent.title");
        this.title = title;
        String platformName = content.getUrlContent().getTencentDocsContent().getPlatformName();
        Intrinsics.checkNotNullExpressionValue(platformName, "content.urlContent.tencentDocsContent.platformName");
        this.platformName = platformName;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w(@NotNull GProStRichTextContent content) {
        this();
        Intrinsics.checkNotNullParameter(content, "content");
        String str = content.urlContent.url;
        Intrinsics.checkNotNullExpressionValue(str, "content.urlContent.url");
        this.docJumpUrl = str;
        String str2 = content.urlContent.tencentDocsContent.icon;
        Intrinsics.checkNotNullExpressionValue(str2, "content.urlContent.tencentDocsContent.icon");
        this.icon = str2;
        String str3 = content.urlContent.tencentDocsContent.url;
        Intrinsics.checkNotNullExpressionValue(str3, "content.urlContent.tencentDocsContent.url");
        this.url = str3;
        String str4 = content.urlContent.tencentDocsContent.permission;
        Intrinsics.checkNotNullExpressionValue(str4, "content.urlContent.tencentDocsContent.permission");
        this.permission = str4;
        String str5 = content.urlContent.tencentDocsContent.title;
        Intrinsics.checkNotNullExpressionValue(str5, "content.urlContent.tencentDocsContent.title");
        this.title = str5;
        String str6 = content.urlContent.tencentDocsContent.platformName;
        Intrinsics.checkNotNullExpressionValue(str6, "content.urlContent.tencentDocsContent.platformName");
        this.platformName = str6;
    }
}
