package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import trpc.zplan.CsCommon$ItemCollect;
import trpc.zplan.CsCommon$RspHeader;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$GetCollectReply extends MessageMicro<AvatarMallMessage$GetCollectReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rsp_header", "collect_item"}, new Object[]{null, null}, AvatarMallMessage$GetCollectReply.class);
    public CsCommon$RspHeader rsp_header = new CsCommon$RspHeader();
    public CsCommon$ItemCollect collect_item = new MessageMicro<CsCommon$ItemCollect>() { // from class: trpc.zplan.CsCommon$ItemCollect
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"item_collect_info"}, new Object[]{null}, CsCommon$ItemCollect.class);
        public final PBRepeatMessageField<CsCommon$ItemCollectInfo> item_collect_info = PBField.initRepeatMessage(CsCommon$ItemCollectInfo.class);
    };
}
