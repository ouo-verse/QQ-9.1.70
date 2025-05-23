package tencent.im.oidb.cmd0xbec;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbec$ReqBody extends MessageMicro<oidb_cmd0xbec$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"search_req", "get_hot_wenda_req"}, new Object[]{null, null}, oidb_cmd0xbec$ReqBody.class);
    public oidb_cmd0xbec$SearchByKeyWordsReq search_req = new MessageMicro<oidb_cmd0xbec$SearchByKeyWordsReq>() { // from class: tencent.im.oidb.cmd0xbec.oidb_cmd0xbec$SearchByKeyWordsReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"bytes_keywords", "msg_cookies", "uint32_page_size"}, new Object[]{ByteStringMicro.EMPTY, null, 0}, oidb_cmd0xbec$SearchByKeyWordsReq.class);
        public final PBBytesField bytes_keywords = PBField.initBytes(ByteStringMicro.EMPTY);
        public oidb_cmd0xbec$Cookies msg_cookies = new oidb_cmd0xbec$Cookies();
        public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
    };
    public oidb_cmd0xbec$GetHotWendaReq get_hot_wenda_req = new MessageMicro<oidb_cmd0xbec$GetHotWendaReq>() { // from class: tencent.im.oidb.cmd0xbec.oidb_cmd0xbec$GetHotWendaReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_cookies", "uint32_page_size"}, new Object[]{null, 0}, oidb_cmd0xbec$GetHotWendaReq.class);
        public oidb_cmd0xbec$Cookies msg_cookies = new oidb_cmd0xbec$Cookies();
        public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
    };
}
