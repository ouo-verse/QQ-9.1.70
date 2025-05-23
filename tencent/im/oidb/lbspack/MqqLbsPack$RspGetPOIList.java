package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class MqqLbsPack$RspGetPOIList extends MessageMicro<MqqLbsPack$RspGetPOIList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_head", "rpt_msg_poi_info_list", "bytes_search_id"}, new Object[]{null, null, ByteStringMicro.EMPTY}, MqqLbsPack$RspGetPOIList.class);
    public MqqLbsPack$RspHead msg_head = new MqqLbsPack$RspHead();
    public final PBRepeatMessageField<MqqLbsPack$PoiInfo> rpt_msg_poi_info_list = PBField.initRepeatMessage(MqqLbsPack$PoiInfo.class);
    public final PBBytesField bytes_search_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
