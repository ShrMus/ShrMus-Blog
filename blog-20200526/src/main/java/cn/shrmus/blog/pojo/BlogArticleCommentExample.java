package cn.shrmus.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogArticleCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogArticleCommentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andArticleCommentIdIsNull() {
            addCriterion("article_comment_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIdIsNotNull() {
            addCriterion("article_comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIdEqualTo(Integer value) {
            addCriterion("article_comment_id =", value, "articleCommentId");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIdNotEqualTo(Integer value) {
            addCriterion("article_comment_id <>", value, "articleCommentId");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIdGreaterThan(Integer value) {
            addCriterion("article_comment_id >", value, "articleCommentId");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_comment_id >=", value, "articleCommentId");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIdLessThan(Integer value) {
            addCriterion("article_comment_id <", value, "articleCommentId");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_comment_id <=", value, "articleCommentId");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIdIn(List<Integer> values) {
            addCriterion("article_comment_id in", values, "articleCommentId");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIdNotIn(List<Integer> values) {
            addCriterion("article_comment_id not in", values, "articleCommentId");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("article_comment_id between", value1, value2, "articleCommentId");
            return (Criteria) this;
        }

        public Criteria andArticleCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_comment_id not between", value1, value2, "articleCommentId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Integer value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Integer value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Integer value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Integer> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleCommmentIsreplyIsNull() {
            addCriterion("article_commment_isreply is null");
            return (Criteria) this;
        }

        public Criteria andArticleCommmentIsreplyIsNotNull() {
            addCriterion("article_commment_isreply is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCommmentIsreplyEqualTo(Integer value) {
            addCriterion("article_commment_isreply =", value, "articleCommmentIsreply");
            return (Criteria) this;
        }

        public Criteria andArticleCommmentIsreplyNotEqualTo(Integer value) {
            addCriterion("article_commment_isreply <>", value, "articleCommmentIsreply");
            return (Criteria) this;
        }

        public Criteria andArticleCommmentIsreplyGreaterThan(Integer value) {
            addCriterion("article_commment_isreply >", value, "articleCommmentIsreply");
            return (Criteria) this;
        }

        public Criteria andArticleCommmentIsreplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_commment_isreply >=", value, "articleCommmentIsreply");
            return (Criteria) this;
        }

        public Criteria andArticleCommmentIsreplyLessThan(Integer value) {
            addCriterion("article_commment_isreply <", value, "articleCommmentIsreply");
            return (Criteria) this;
        }

        public Criteria andArticleCommmentIsreplyLessThanOrEqualTo(Integer value) {
            addCriterion("article_commment_isreply <=", value, "articleCommmentIsreply");
            return (Criteria) this;
        }

        public Criteria andArticleCommmentIsreplyIn(List<Integer> values) {
            addCriterion("article_commment_isreply in", values, "articleCommmentIsreply");
            return (Criteria) this;
        }

        public Criteria andArticleCommmentIsreplyNotIn(List<Integer> values) {
            addCriterion("article_commment_isreply not in", values, "articleCommmentIsreply");
            return (Criteria) this;
        }

        public Criteria andArticleCommmentIsreplyBetween(Integer value1, Integer value2) {
            addCriterion("article_commment_isreply between", value1, value2, "articleCommmentIsreply");
            return (Criteria) this;
        }

        public Criteria andArticleCommmentIsreplyNotBetween(Integer value1, Integer value2) {
            addCriterion("article_commment_isreply not between", value1, value2, "articleCommmentIsreply");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorIsNull() {
            addCriterion("user_id_author is null");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorIsNotNull() {
            addCriterion("user_id_author is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorEqualTo(Integer value) {
            addCriterion("user_id_author =", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorNotEqualTo(Integer value) {
            addCriterion("user_id_author <>", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorGreaterThan(Integer value) {
            addCriterion("user_id_author >", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id_author >=", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorLessThan(Integer value) {
            addCriterion("user_id_author <", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorLessThanOrEqualTo(Integer value) {
            addCriterion("user_id_author <=", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorIn(List<Integer> values) {
            addCriterion("user_id_author in", values, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorNotIn(List<Integer> values) {
            addCriterion("user_id_author not in", values, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorBetween(Integer value1, Integer value2) {
            addCriterion("user_id_author between", value1, value2, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id_author not between", value1, value2, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyIsNull() {
            addCriterion("user_id_reply is null");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyIsNotNull() {
            addCriterion("user_id_reply is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyEqualTo(Integer value) {
            addCriterion("user_id_reply =", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyNotEqualTo(Integer value) {
            addCriterion("user_id_reply <>", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyGreaterThan(Integer value) {
            addCriterion("user_id_reply >", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id_reply >=", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyLessThan(Integer value) {
            addCriterion("user_id_reply <", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyLessThanOrEqualTo(Integer value) {
            addCriterion("user_id_reply <=", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyIn(List<Integer> values) {
            addCriterion("user_id_reply in", values, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyNotIn(List<Integer> values) {
            addCriterion("user_id_reply not in", values, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyBetween(Integer value1, Integer value2) {
            addCriterion("user_id_reply between", value1, value2, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id_reply not between", value1, value2, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPublishTimeIsNull() {
            addCriterion("article_comment_publish_time is null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPublishTimeIsNotNull() {
            addCriterion("article_comment_publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPublishTimeEqualTo(Date value) {
            addCriterion("article_comment_publish_time =", value, "articleCommentPublishTime");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPublishTimeNotEqualTo(Date value) {
            addCriterion("article_comment_publish_time <>", value, "articleCommentPublishTime");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPublishTimeGreaterThan(Date value) {
            addCriterion("article_comment_publish_time >", value, "articleCommentPublishTime");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("article_comment_publish_time >=", value, "articleCommentPublishTime");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPublishTimeLessThan(Date value) {
            addCriterion("article_comment_publish_time <", value, "articleCommentPublishTime");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("article_comment_publish_time <=", value, "articleCommentPublishTime");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPublishTimeIn(List<Date> values) {
            addCriterion("article_comment_publish_time in", values, "articleCommentPublishTime");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPublishTimeNotIn(List<Date> values) {
            addCriterion("article_comment_publish_time not in", values, "articleCommentPublishTime");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPublishTimeBetween(Date value1, Date value2) {
            addCriterion("article_comment_publish_time between", value1, value2, "articleCommentPublishTime");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("article_comment_publish_time not between", value1, value2, "articleCommentPublishTime");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPidIsNull() {
            addCriterion("article_comment_pid is null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPidIsNotNull() {
            addCriterion("article_comment_pid is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPidEqualTo(Integer value) {
            addCriterion("article_comment_pid =", value, "articleCommentPid");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPidNotEqualTo(Integer value) {
            addCriterion("article_comment_pid <>", value, "articleCommentPid");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPidGreaterThan(Integer value) {
            addCriterion("article_comment_pid >", value, "articleCommentPid");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_comment_pid >=", value, "articleCommentPid");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPidLessThan(Integer value) {
            addCriterion("article_comment_pid <", value, "articleCommentPid");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPidLessThanOrEqualTo(Integer value) {
            addCriterion("article_comment_pid <=", value, "articleCommentPid");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPidIn(List<Integer> values) {
            addCriterion("article_comment_pid in", values, "articleCommentPid");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPidNotIn(List<Integer> values) {
            addCriterion("article_comment_pid not in", values, "articleCommentPid");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPidBetween(Integer value1, Integer value2) {
            addCriterion("article_comment_pid between", value1, value2, "articleCommentPid");
            return (Criteria) this;
        }

        public Criteria andArticleCommentPidNotBetween(Integer value1, Integer value2) {
            addCriterion("article_comment_pid not between", value1, value2, "articleCommentPid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}