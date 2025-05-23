package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class RecommendProxyOuterClass$KuolieRoomInfo extends MessageMicro<RecommendProxyOuterClass$KuolieRoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{AudienceReportConst.ROOM_ID, "room_index"}, new Object[]{0L, 0L}, RecommendProxyOuterClass$KuolieRoomInfo.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt64Field room_index = PBField.initUInt64(0);
}
