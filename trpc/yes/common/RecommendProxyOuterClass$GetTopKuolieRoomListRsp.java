package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class RecommendProxyOuterClass$GetTopKuolieRoomListRsp extends MessageMicro<RecommendProxyOuterClass$GetTopKuolieRoomListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"room_list"}, new Object[]{null}, RecommendProxyOuterClass$GetTopKuolieRoomListRsp.class);
    public final PBRepeatMessageField<RecommendProxyOuterClass$KuolieRoomInfo> room_list = PBField.initRepeatMessage(RecommendProxyOuterClass$KuolieRoomInfo.class);
}
