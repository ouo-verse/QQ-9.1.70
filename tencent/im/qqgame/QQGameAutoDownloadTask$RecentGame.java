package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameAutoDownloadTask$RecentGame extends MessageMicro<QQGameAutoDownloadTask$RecentGame> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 24}, new String[]{"appid", "online_time"}, new Object[]{"", 0L}, QQGameAutoDownloadTask$RecentGame.class);
    public final PBStringField appid = PBField.initString("");
    public final PBInt64Field online_time = PBField.initInt64(0);
}
