package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes30.dex */
public final class QsmDataOuterClass$QSMPlayerInfoWithStatus extends MessageMicro<QsmDataOuterClass$QSMPlayerInfoWithStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"player_info", "player_status"}, new Object[]{null, 0}, QsmDataOuterClass$QSMPlayerInfoWithStatus.class);
    public QsmDataOuterClass$QSMPlayerInfo player_info = new QsmDataOuterClass$QSMPlayerInfo();
    public final PBInt32Field player_status = PBField.initInt32(0);
}
