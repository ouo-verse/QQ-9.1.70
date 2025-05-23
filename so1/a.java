package so1;

import android.util.Log;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBusinessInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBusinessNode;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelMemberInfos;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildThemeInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealTimeChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealTimeLiveChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealTimeVoiceChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoomInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserAVInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserDevState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import so1.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u0016"}, d2 = {"Lso1/a;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRealTimeLiveChannel;", "liveInfo", "", "guildId", "channelId", "Lso1/h;", "d", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRoomInfo;", "roomInfo", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRealTimeVoiceChannel;", "audioInfo", "e", "Lso1/b;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRealTimeChannel;", "info", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f434027a = new a();

    a() {
    }

    private final b a(GProRealTimeVoiceChannel audioInfo, String guildId, String channelId) {
        int i3;
        String str;
        GProChannelMemberInfos gProChannelMemberInfos = audioInfo.memberInfos;
        String str2 = null;
        if (gProChannelMemberInfos.isActive) {
            return null;
        }
        ArrayList<GProGuildThemeInfo> arrayList = gProChannelMemberInfos.channelConfig.themeList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "audioInfo.memberInfos.channelConfig.themeList");
        Iterator<T> it = arrayList.iterator();
        int i16 = 1;
        loop0: while (true) {
            i3 = i16;
            while (it.hasNext()) {
                i16 = ((GProGuildThemeInfo) it.next()).themeType;
                if (i16 == 2 || i16 == 7 || i16 == 6 || i16 == 4) {
                }
            }
            break loop0;
        }
        IGProChannelInfo B = ch.B(channelId);
        if (B != null) {
            str2 = B.getChannelName();
        }
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        String str3 = audioInfo.memberInfos.channelConfig.themeInfo.sessionId;
        Intrinsics.checkNotNullExpressionValue(str3, "audioInfo.memberInfos.ch\u2026onfig.themeInfo.sessionId");
        return new b(guildId, channelId, str, str3, i3);
    }

    private final String b(GProRoomInfo roomInfo) {
        String str;
        boolean z16;
        boolean isBlank;
        HashMap<String, String> hashMap = roomInfo.roomIcons;
        Object obj = null;
        String str2 = "";
        if (hashMap != null) {
            String str3 = hashMap.get("1:1");
            if (str3 == null) {
                str3 = "";
            }
            str = str3;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Collection<String> values = roomInfo.roomIcons.values();
            Intrinsics.checkNotNullExpressionValue(values, "roomInfo.roomIcons.values");
            Iterator<T> it = values.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String it5 = (String) next;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                isBlank = StringsKt__StringsJVMKt.isBlank(it5);
                if (!isBlank) {
                    obj = next;
                    break;
                }
            }
            String str4 = (String) obj;
            if (str4 != null) {
                str2 = str4;
            }
            Intrinsics.checkNotNullExpressionValue(str2, "roomInfo.roomIcons.value\u2026{ it.isNotBlank() } ?: \"\"");
            return str2;
        }
        return str;
    }

    private final h d(GProRealTimeLiveChannel liveInfo, String guildId, String channelId) {
        String str;
        boolean z16;
        String str2 = "";
        String str3 = null;
        if (liveInfo.roomInfo.isActive) {
            IGProChannelInfo B = ch.B(channelId);
            if (B != null) {
                str3 = B.getChannelName();
            }
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
            GProRoomInfo gProRoomInfo = liveInfo.roomInfo.roomInfo;
            Intrinsics.checkNotNullExpressionValue(gProRoomInfo, "liveInfo.roomInfo.roomInfo");
            String b16 = b(gProRoomInfo);
            if (b16.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                b16 = "https://downv6.qq.com/innovate/guild/cover_info/active_channel_live.png";
            }
            return new GuildHomeLiveChannelUIData(guildId, channelId, str, b16, null, String.valueOf(liveInfo.roomInfo.roomInfo.roomId), 16, null);
        }
        IGProChannelInfo B2 = ch.B(channelId);
        if (B2 != null) {
            str3 = B2.getChannelName();
        }
        if (str3 != null) {
            str2 = str3;
        }
        return new k(guildId, channelId, str2, String.valueOf(liveInfo.roomInfo.roomInfo.roomId));
    }

    private final h e(GProRealTimeVoiceChannel audioInfo, String guildId, String channelId) {
        String str;
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        String str2;
        boolean z16;
        GProUserAVInfo gProUserAVInfo;
        GProUserDevState gProUserDevState;
        b a16 = a(audioInfo, guildId, channelId);
        if (a16 != null) {
            return a16;
        }
        ArrayList<GProUser> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<GProUser> arrayList3 = audioInfo.memberInfos.memberList;
        boolean z17 = false;
        if (arrayList3 != null) {
            for (GProUser user : arrayList3) {
                if (user.voiceInfo != null) {
                    GProBusinessInfo gProBusinessInfo = user.businessInfo;
                    if (gProBusinessInfo != null && (gProUserAVInfo = gProBusinessInfo.userAVInfo) != null && (gProUserDevState = gProUserAVInfo.userDevState) != null && gProUserDevState.micState == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        Intrinsics.checkNotNullExpressionValue(user, "user");
                        arrayList.add(user);
                    } else {
                        Intrinsics.checkNotNullExpressionValue(user, "user");
                        arrayList2.add(user);
                    }
                }
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (GProUser gProUser : arrayList) {
            String valueOf = String.valueOf(gProUser.tinyId);
            String str3 = gProUser.avatarMeta;
            Intrinsics.checkNotNullExpressionValue(str3, "it.avatarMeta");
            arrayList4.add(new h.MicUser(valueOf, str3, true));
        }
        ArrayList<GProGuildThemeInfo> arrayList5 = audioInfo.memberInfos.channelConfig.themeList;
        Intrinsics.checkNotNullExpressionValue(arrayList5, "audioInfo.memberInfos.channelConfig.themeList");
        Iterator<T> it = arrayList5.iterator();
        while (true) {
            String str4 = null;
            if (it.hasNext()) {
                GProGuildThemeInfo gProGuildThemeInfo = (GProGuildThemeInfo) it.next();
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.NewHome.content.active.GuildHomeActiveChannelDataFactory", "");
                }
                int i3 = gProGuildThemeInfo.themeType;
                if (i3 != 2) {
                    if (i3 != 4) {
                        if (i3 != 6) {
                            if (i3 == 7) {
                                ArrayList<GProBusinessNode> arrayList6 = audioInfo.memberInfos.channelConfig.businessList;
                                Intrinsics.checkNotNullExpressionValue(arrayList6, "audioInfo.memberInfos.channelConfig.businessList");
                                for (GProBusinessNode gProBusinessNode : arrayList6) {
                                    if (gProBusinessNode.nodeType == 2) {
                                        Logger.f235387a.d().d("Guild.NewHome.content.active.GuildHomeActiveChannelDataFactory", 1, "ofVoiceData SCREEN_SHARE " + gProBusinessNode.screenShareInfo.screenPic);
                                        String str5 = gProBusinessNode.screenShareInfo.screenPic;
                                        if (str5.length() == 0) {
                                            z17 = true;
                                        }
                                        if (z17) {
                                            str5 = "https://downv6.qq.com/innovate/guild/cover_info/active_channel_screen.png";
                                        }
                                        IGProChannelInfo B = ch.B(channelId);
                                        if (B != null) {
                                            str4 = B.getChannelName();
                                        }
                                        if (str4 == null) {
                                            str2 = "";
                                        } else {
                                            Intrinsics.checkNotNullExpressionValue(str4, "QQGuildUtil.getChannelIn\u2026nelId)?.channelName ?: \"\"");
                                            str2 = str4;
                                        }
                                        String themeName = gProGuildThemeInfo.themeName;
                                        GProChannelMemberInfos gProChannelMemberInfos = audioInfo.memberInfos;
                                        int i16 = gProChannelMemberInfos.noMemberMaxLimit;
                                        int i17 = gProChannelMemberInfos.channelMemberMax;
                                        int i18 = gProChannelMemberInfos.channelMemberCount;
                                        String sessionId = gProChannelMemberInfos.channelConfig.themeInfo.sessionId;
                                        Intrinsics.checkNotNullExpressionValue(str5, "ifEmpty { SCREEN_SHARE_DEFAULT_BG }");
                                        Intrinsics.checkNotNullExpressionValue(themeName, "themeName");
                                        Intrinsics.checkNotNullExpressionValue(sessionId, "sessionId");
                                        return new GuildHomeAudioScreenChannelUIData(guildId, channelId, str2, str5, themeName, i16, i17, i18, sessionId, 7);
                                    }
                                }
                            }
                        } else {
                            String str6 = gProGuildThemeInfo.themeBgImg;
                            isBlank3 = StringsKt__StringsJVMKt.isBlank(str6);
                            if (isBlank3) {
                                str6 = gProGuildThemeInfo.themeIcon;
                            }
                            IGProChannelInfo B2 = ch.B(channelId);
                            if (B2 != null) {
                                str4 = B2.getChannelName();
                            }
                            if (str4 == null) {
                                str4 = "";
                            } else {
                                Intrinsics.checkNotNullExpressionValue(str4, "QQGuildUtil.getChannelIn\u2026nelId)?.channelName ?: \"\"");
                            }
                            String themeName2 = gProGuildThemeInfo.themeName;
                            GProChannelMemberInfos gProChannelMemberInfos2 = audioInfo.memberInfos;
                            int i19 = gProChannelMemberInfos2.noMemberMaxLimit;
                            int i26 = gProChannelMemberInfos2.channelMemberMax;
                            int i27 = gProChannelMemberInfos2.channelMemberCount;
                            String sessionId2 = gProChannelMemberInfos2.channelConfig.themeInfo.sessionId;
                            Intrinsics.checkNotNullExpressionValue(str6, "ifBlank { theme.themeIcon }");
                            Intrinsics.checkNotNullExpressionValue(themeName2, "themeName");
                            Intrinsics.checkNotNullExpressionValue(sessionId2, "sessionId");
                            return new GuildHomeAudioLobbyChannelUIData(guildId, channelId, str4, str6, arrayList4, themeName2, i19, i26, i27, sessionId2, 6);
                        }
                    } else {
                        String str7 = gProGuildThemeInfo.themeBgImg;
                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str7);
                        if (isBlank2) {
                            str7 = gProGuildThemeInfo.themeIcon;
                        }
                        IGProChannelInfo B3 = ch.B(channelId);
                        if (B3 != null) {
                            str4 = B3.getChannelName();
                        }
                        if (str4 == null) {
                            str4 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str4, "QQGuildUtil.getChannelIn\u2026nelId)?.channelName ?: \"\"");
                        }
                        String themeName3 = gProGuildThemeInfo.themeName;
                        GProChannelMemberInfos gProChannelMemberInfos3 = audioInfo.memberInfos;
                        int i28 = gProChannelMemberInfos3.noMemberMaxLimit;
                        int i29 = gProChannelMemberInfos3.channelMemberMax;
                        int i36 = gProChannelMemberInfos3.channelMemberCount;
                        String sessionId3 = gProChannelMemberInfos3.channelConfig.themeInfo.sessionId;
                        Intrinsics.checkNotNullExpressionValue(str7, "ifBlank { theme.themeIcon }");
                        Intrinsics.checkNotNullExpressionValue(themeName3, "themeName");
                        Intrinsics.checkNotNullExpressionValue(sessionId3, "sessionId");
                        return new GuildHomeAudioListenChannelUIData(guildId, channelId, str4, str7, arrayList4, themeName3, i28, i29, i36, sessionId3, 4);
                    }
                } else {
                    String str8 = gProGuildThemeInfo.themeBgImg;
                    isBlank = StringsKt__StringsJVMKt.isBlank(str8);
                    if (isBlank) {
                        str8 = gProGuildThemeInfo.themeIcon;
                    }
                    IGProChannelInfo B4 = ch.B(channelId);
                    if (B4 != null) {
                        str4 = B4.getChannelName();
                    }
                    if (str4 == null) {
                        str4 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str4, "QQGuildUtil.getChannelIn\u2026nelId)?.channelName ?: \"\"");
                    }
                    String themeName4 = gProGuildThemeInfo.themeName;
                    GProChannelMemberInfos gProChannelMemberInfos4 = audioInfo.memberInfos;
                    int i37 = gProChannelMemberInfos4.noMemberMaxLimit;
                    int i38 = gProChannelMemberInfos4.channelMemberMax;
                    int i39 = gProChannelMemberInfos4.channelMemberCount;
                    String sessionId4 = gProChannelMemberInfos4.channelConfig.themeInfo.sessionId;
                    Intrinsics.checkNotNullExpressionValue(str8, "ifBlank { theme.themeIcon }");
                    Intrinsics.checkNotNullExpressionValue(themeName4, "themeName");
                    Intrinsics.checkNotNullExpressionValue(sessionId4, "sessionId");
                    return new GuildHomeAudioPlayChannelUIData(guildId, channelId, str4, str8, arrayList4, themeName4, i37, i38, i39, sessionId4, 2);
                }
            } else {
                IGProChannelInfo B5 = ch.B(channelId);
                if (B5 != null) {
                    str4 = B5.getChannelName();
                }
                if (str4 == null) {
                    str = "";
                } else {
                    str = str4;
                }
                GProChannelMemberInfos gProChannelMemberInfos5 = audioInfo.memberInfos;
                int i46 = gProChannelMemberInfos5.noMemberMaxLimit;
                int i47 = gProChannelMemberInfos5.channelMemberMax;
                int i48 = gProChannelMemberInfos5.channelMemberCount;
                String str9 = gProChannelMemberInfos5.channelConfig.themeInfo.sessionId;
                Intrinsics.checkNotNullExpressionValue(str9, "audioInfo.memberInfos.ch\u2026onfig.themeInfo.sessionId");
                return new GuildHomeAudioNormalChannelUIData(guildId, channelId, str, arrayList4, i46, i47, i48, str9, 1);
            }
        }
    }

    @Nullable
    public final h c(@NotNull GProRealTimeChannel info, @NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        int i3 = info.channelType;
        if (i3 != 2) {
            if (i3 != 5) {
                return null;
            }
            GProRealTimeLiveChannel gProRealTimeLiveChannel = info.liveChannel;
            Intrinsics.checkNotNullExpressionValue(gProRealTimeLiveChannel, "info.liveChannel");
            return d(gProRealTimeLiveChannel, guildId, channelId);
        }
        GProRealTimeVoiceChannel gProRealTimeVoiceChannel = info.voiceChannel;
        Intrinsics.checkNotNullExpressionValue(gProRealTimeVoiceChannel, "info.voiceChannel");
        return e(gProRealTimeVoiceChannel, guildId, channelId);
    }
}
