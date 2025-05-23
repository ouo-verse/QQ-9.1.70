package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleEnvHub$GetUserFullEnvRsp extends MessageMicro<QQCircleEnvHub$GetUserFullEnvRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"tipsList", "userLayerInfo", ITVKPlayerEventListener.KEY_USER_INFO, "commentEffectInfo"}, new Object[]{null, null, null, null}, QQCircleEnvHub$GetUserFullEnvRsp.class);
    public final PBRepeatMessageField<QQCircleEnvHub$Tips> tipsList = PBField.initRepeatMessage(QQCircleEnvHub$Tips.class);
    public QQCircleEnvHub$UserLayerInfo userLayerInfo = new QQCircleEnvHub$UserLayerInfo();
    public QQCircleEnvHub$UserInfo userInfo = new QQCircleEnvHub$UserInfo();
    public QQCircleEnvHub$CommentEffectInfo commentEffectInfo = new QQCircleEnvHub$CommentEffectInfo();
}
