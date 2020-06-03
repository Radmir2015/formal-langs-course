// Generated from syntax.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link syntaxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface syntaxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link syntaxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(syntaxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link syntaxParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(syntaxParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orXorOp}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrXorOp(syntaxParser.OrXorOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(syntaxParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andOp}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOp(syntaxParser.AndOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notOp}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotOp(syntaxParser.NotOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ident}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(syntaxParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integer}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(syntaxParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printId}
	 * labeled alternative in {@link syntaxParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintId(syntaxParser.PrintIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link syntaxParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(syntaxParser.PrintExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link syntaxParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(syntaxParser.AssignExprContext ctx);
}