package tencent.im.troop.findtroop;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;

/* loaded from: classes29.dex */
public final class TabRecommendPB$GetTabRecommendRsp extends MessageMicro<TabRecommendPB$GetTabRecommendRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 802}, new String[]{"tab", "tab_recommend_result", "is_end", AppConstants.Key.SESSION_INFO, "next_request_delay", MimeTypeParser.ATTR_EXTENSION}, new Object[]{0, null, 0, null, 0L, ByteStringMicro.EMPTY}, TabRecommendPB$GetTabRecommendRsp.class);
    public final PBUInt32Field tab = PBField.initUInt32(0);
    public final PBRepeatMessageField<TabRecommendPB$TabRecommendResult> tab_recommend_result = PBField.initRepeatMessage(TabRecommendPB$TabRecommendResult.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public TabRecommendPB$Session session_info = new TabRecommendPB$Session();
    public final PBUInt64Field next_request_delay = PBField.initUInt64(0);
    public final PBBytesField extension = PBField.initBytes(ByteStringMicro.EMPTY);
}
