package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import trpc.zplan.CsCommon$MyItemInfoList;
import trpc.zplan.CsCommon$RspHeader;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$GetMyItemsReply extends MessageMicro<AvatarMallMessage$GetMyItemsReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rsp_header", "myitem_list"}, new Object[]{null, null}, AvatarMallMessage$GetMyItemsReply.class);
    public CsCommon$RspHeader rsp_header = new CsCommon$RspHeader();
    public CsCommon$MyItemInfoList myitem_list = new MessageMicro<CsCommon$MyItemInfoList>() { // from class: trpc.zplan.CsCommon$MyItemInfoList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"my_items"}, new Object[]{null}, CsCommon$MyItemInfoList.class);
        public final PBRepeatMessageField<CsCommon$MyItemInfo> my_items = PBField.initRepeatMessage(CsCommon$MyItemInfo.class);
    };
}
