package tencent.im.new_year_ranking;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PackRanking$PkgResp extends MessageMicro<PackRanking$PkgResp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public PackRanking$QueryRankingResp query_ranking;
    public final PBBytesField resp_name;
    public final PBBytesField retmsg;
    public final PBUInt32Field cmdtype = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field retcode = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 82}, new String[]{"cmdtype", "uin", "retcode", "retmsg", "resp_name", "query_ranking"}, new Object[]{0, 0L, 0, byteStringMicro, byteStringMicro, null}, PackRanking$PkgResp.class);
    }

    public PackRanking$PkgResp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.retmsg = PBField.initBytes(byteStringMicro);
        this.resp_name = PBField.initBytes(byteStringMicro);
        this.query_ranking = new PackRanking$QueryRankingResp();
    }
}
