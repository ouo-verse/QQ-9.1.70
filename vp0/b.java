package vp0;

import android.annotation.SuppressLint;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0010\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u001a\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0007\u001a\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b\"\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", DTConstants.TAG.ELEMENT, "", "e", "", "lDeadTime", "", "a", LayoutAttrDefine.CLICK_URI, "b", "filePath", "", "d", TagName.FILE_TYPE, "c", "Ljava/util/HashMap;", "Ljava/util/HashMap;", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static HashMap<String, Integer> f442133a = new HashMap<>();

    @Nullable
    public static final String a(long j3) {
        long j16 = j3 * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        if (j16 <= currentTimeMillis) {
            return "\u5df2\u8fc7\u671f";
        }
        return (((j16 - currentTimeMillis) / 86400000) + 1) + "\u5929\u540e\u5230\u671f";
    }

    @NotNull
    public static final String b(@Nullable String str) {
        boolean endsWith$default;
        int lastIndexOf$default;
        String replace$default;
        int lastIndexOf$default2;
        String replace$default2;
        String replace$default3;
        boolean equals;
        if (str == null) {
            return "";
        }
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, ".rename", false, 2, null);
        if (endsWith$default) {
            replace$default = StringsKt__StringsJVMKt.replace$default(str, ".rename", "", false, 4, (Object) null);
            lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) replace$default, ".", 0, false, 6, (Object) null);
            if (lastIndexOf$default2 == -1) {
                return "";
            }
            String substring = replace$default.substring(lastIndexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            replace$default2 = StringsKt__StringsJVMKt.replace$default(new Regex("[0-9]*").replace(substring, ""), "(", "", false, 4, (Object) null);
            replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, ")", "", false, 4, (Object) null);
            equals = StringsKt__StringsJVMKt.equals(replace$default3, ".apk", true);
            if (equals) {
                return ".apk.rename";
            }
        }
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, ".", 0, false, 6, (Object) null);
        if (lastIndexOf$default < 0) {
            return "";
        }
        String substring2 = str.substring(lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        return substring2;
    }

    public static final int c(int i3) {
        switch (i3) {
            case -1:
            case 11:
            case 13:
            default:
                return R.drawable.guild_file_unknow;
            case 0:
                return R.drawable.guild_file_jpg;
            case 1:
                return R.drawable.guild_file_mp3;
            case 2:
                return R.drawable.guild_file_video;
            case 3:
                return R.drawable.guild_file_doc;
            case 4:
                return R.drawable.guild_file_zip;
            case 5:
                return R.drawable.guild_file_apk;
            case 6:
                return R.drawable.guild_file_xls;
            case 7:
                return R.drawable.guild_file_ppt;
            case 8:
                return R.drawable.guild_file_html;
            case 9:
                return R.drawable.guild_file_pdf;
            case 10:
                return R.drawable.guild_file_txt;
            case 12:
                return R.drawable.guild_file_psd;
            case 14:
                return R.drawable.guild_file_ai;
            case 15:
                return R.drawable.guild_file_font;
            case 16:
                return R.drawable.guild_file_ipa;
            case 17:
                return R.drawable.guild_file_keynote;
            case 18:
                return R.drawable.guild_file_note;
            case 19:
                return R.drawable.guild_file_numbers;
            case 20:
                return R.drawable.guild_file_pages;
            case 21:
                return R.drawable.guild_file_sketch;
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static final synchronized int d(@NotNull String filePath) {
        boolean z16;
        synchronized (b.class) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            String b16 = b(filePath);
            if (b16.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i3 = -1;
            if (z16) {
                return -1;
            }
            String lowerCase = b16.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            if (f442133a.isEmpty()) {
                f442133a.put(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION, 1);
                f442133a.put(".3gpp", 1);
                f442133a.put(".flac", 1);
                f442133a.put(".ogg", 1);
                f442133a.put(".wav", 1);
                f442133a.put(".m4a", 1);
                f442133a.remove(".flv");
                f442133a.remove(".m");
                f442133a.remove(".webp");
                f442133a.remove(".vcf");
                f442133a.put(".bmp", 0);
                f442133a.put(".jpg", 0);
                f442133a.put(".jpeg", 0);
                f442133a.put(".png", 0);
                f442133a.put(QzoneEmotionUtils.SIGN_ICON_URL_END, 0);
                f442133a.put(".webp", 0);
                f442133a.put(".psd", 12);
                f442133a.put(".swf", 2);
                f442133a.put(".mov", 2);
                f442133a.put(".mp4", 2);
                f442133a.put(".3gp", 2);
                f442133a.put(".avi", 2);
                f442133a.put(".rmvb", 2);
                f442133a.put(".mpg", 2);
                f442133a.put(".rm", 2);
                f442133a.put(".asf", 2);
                f442133a.put(".mpeg", 2);
                f442133a.put(".mkv", 2);
                f442133a.put(".wmv", 2);
                f442133a.put(".flv", 2);
                f442133a.put(".f4v", 2);
                f442133a.put(".webm", 2);
                f442133a.put(".mod", 2);
                f442133a.put(".mpe", 2);
                f442133a.put(".fla", 2);
                f442133a.put(".m4r", 2);
                f442133a.put(".m4u", 2);
                f442133a.put(".m4v", 2);
                f442133a.put(".vob", 2);
                f442133a.put(".doc", 3);
                f442133a.put(".docx", 3);
                f442133a.put(".wps", 3);
                f442133a.put(".pages", 3);
                f442133a.put(".zip", 4);
                f442133a.put(".rar", 4);
                f442133a.put(".7z", 4);
                f442133a.put(".tar", 4);
                f442133a.put(".iso", 4);
                f442133a.put(".gz", 4);
                f442133a.put(".apk", 5);
                f442133a.put(".apk.rename", 5);
                f442133a.put(".xls", 6);
                f442133a.put(".xlsx", 6);
                f442133a.put(".csv", 6);
                f442133a.put(".numbers", 6);
                f442133a.put(".et", 6);
                f442133a.put(".ppt", 7);
                f442133a.put(".pptx", 7);
                f442133a.put(".pps", 7);
                f442133a.put(".dps", 7);
                f442133a.put(".keynotes", 7);
                f442133a.put(".htm", 8);
                f442133a.put(".html", 8);
                f442133a.put(".php", 8);
                f442133a.put(".pdf", 9);
                f442133a.put(".txt", 10);
                f442133a.put(".epub", 10);
                f442133a.put(".rtf", 10);
                f442133a.put(".c", 10);
                f442133a.put(".conf", 10);
                f442133a.put(".cpp", 10);
                f442133a.put(".h", 10);
                f442133a.put(".java", 10);
                f442133a.put(".log", 10);
                f442133a.put(".prop", 10);
                f442133a.put(".rc", 10);
                f442133a.put(".sh", 10);
                f442133a.put(".csv", 10);
                f442133a.put(".xml", 10);
                f442133a.put(".ai", 14);
                f442133a.put(".font", 15);
                f442133a.put(".ipa", 16);
                f442133a.put(".keynote", 17);
                f442133a.put(".note", 18);
                f442133a.put(".numbers", 19);
                f442133a.put(".pages", 20);
                f442133a.put(".sketch", 21);
            }
            HashMap<String, Integer> hashMap = f442133a;
            String lowerCase2 = lowerCase.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
            if (hashMap.containsKey(lowerCase2)) {
                HashMap<String, Integer> hashMap2 = f442133a;
                String lowerCase3 = lowerCase.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase()");
                Integer num = hashMap2.get(lowerCase3);
                if (num != null) {
                    i3 = num.intValue();
                }
                return i3;
            }
            return 11;
        }
    }

    public static final boolean e(@NotNull FileElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (System.currentTimeMillis() > element.expireTime.longValue() * 1000) {
            return true;
        }
        return false;
    }
}
