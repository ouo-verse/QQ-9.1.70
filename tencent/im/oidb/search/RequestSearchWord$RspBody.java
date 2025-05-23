package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RequestSearchWord$RspBody extends MessageMicro<RequestSearchWord$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_search_keywords"}, new Object[]{null}, RequestSearchWord$RspBody.class);
    public RequestSearchWord$SearchKeywords msg_search_keywords = new MessageMicro<RequestSearchWord$SearchKeywords>() { // from class: tencent.im.oidb.search.RequestSearchWord$SearchKeywords
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{26, 34, 42}, new String[]{"rcmds", "sid", "sessionid"}, new Object[]{null, ByteStringMicro.EMPTY, ""}, RequestSearchWord$SearchKeywords.class);
        public final PBRepeatMessageField<RequestSearchWord$Rcmd> rcmds = PBField.initRepeatMessage(RequestSearchWord$Rcmd.class);
        public final PBBytesField sid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBStringField sessionid = PBField.initString("");
    };
}
