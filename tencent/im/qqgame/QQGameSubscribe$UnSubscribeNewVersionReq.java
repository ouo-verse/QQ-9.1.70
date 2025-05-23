package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameSubscribe$UnSubscribeNewVersionReq extends MessageMicro<QQGameSubscribe$UnSubscribeNewVersionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"version"}, new Object[]{null}, QQGameSubscribe$UnSubscribeNewVersionReq.class);
    public QQGameSubscribe$GameVersion version = new QQGameSubscribe$GameVersion();
}
