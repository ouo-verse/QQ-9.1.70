package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameLobbyInfo$BannerInfo extends MessageMicro<AvGameLobbyInfo$BannerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"picture_url", "skip_url"}, new Object[]{"", ""}, AvGameLobbyInfo$BannerInfo.class);
    public final PBStringField picture_url = PBField.initString("");
    public final PBStringField skip_url = PBField.initString("");
}
